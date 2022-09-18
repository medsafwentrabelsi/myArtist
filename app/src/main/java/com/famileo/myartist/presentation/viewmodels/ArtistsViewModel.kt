package com.famileo.myartist.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.famileo.myartist.domain.models.toUiArtist
import com.famileo.myartist.domain.usescases.FetchArtistUseCase
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
) : ViewModel() {

    private val _artistsList: MutableStateFlow<List<UiArtist>?> = MutableStateFlow(null)
    val artistsList: StateFlow<List<UiArtist>?> = _artistsList

    /**
     *  Fetch artists.
     */
    fun fetchArtist(artistName: String) {
        viewModelScope.launch {
            _artistsList.emit(fetchArtistUseCase.invoke(artistName)?.map { it.toUiArtist() })
        }
    }
}