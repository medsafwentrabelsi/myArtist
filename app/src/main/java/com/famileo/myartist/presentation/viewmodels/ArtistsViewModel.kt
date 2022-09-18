package com.famileo.myartist.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.famileo.myartist.domain.models.toUiArtist
import com.famileo.myartist.domain.usescases.FetchArtistUseCase
import com.famileo.myartist.domain.usescases.GetArtistsUseCase
import com.famileo.myartist.presentation.models.UiArtist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ArtistsViewModel view model.
 */
class ArtistsViewModel @Inject constructor(
    /** Fetch artists use case. */
    private var fetchArtistUseCase: FetchArtistUseCase,
    /** Get artists use case. */
    private var getArtistsUseCase: GetArtistsUseCase
) : ViewModel() {

    private val _artistsList: MutableStateFlow<List<UiArtist>?> = MutableStateFlow(null)
    val artistsList: StateFlow<List<UiArtist>?> = _artistsList

    private val _progressBarVisibility: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val progressBarVisibility: StateFlow<Boolean> = _progressBarVisibility

    /**
     *  Fetch artists.
     */
    fun fetchArtist(artistName: String) {
        viewModelScope.launch {
            _progressBarVisibility.emit(true)
            fetchArtistUseCase.invoke(artistName)
            getArtist()
        }
    }

    /**
     *  Get artists.
     */
    fun getArtist() {
        viewModelScope.launch {
            getArtistsUseCase.invoke().collect { it ->
                _progressBarVisibility.emit(false)
                _artistsList.emit(it.map { it.toUiArtist() })
            }
        }


    }
}