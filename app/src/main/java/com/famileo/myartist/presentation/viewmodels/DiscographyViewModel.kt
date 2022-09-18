package com.famileo.myartist.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.famileo.myartist.domain.models.toUiDiscography
import com.famileo.myartist.domain.usescases.FetchArtistDiscographyUseCase
import com.famileo.myartist.presentation.models.UiDiscography
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ArtistsViewModel view model.
 */
class DiscographyViewModel @Inject constructor(
    /** Fetch discography use case. */
    private var fetchArtistDiscographyUseCase: FetchArtistDiscographyUseCase,
) : ViewModel() {

    private val _artistDiscography: MutableStateFlow<List<UiDiscography>?> = MutableStateFlow(null)
    val artistsDiscography: StateFlow<List<UiDiscography>?> = _artistDiscography

    /**
     *  Fetch discography.
     */
    fun fetchArtistDiscography(artistId: String) {
        viewModelScope.launch {
            _artistDiscography.emit(fetchArtistDiscographyUseCase.invoke(artistId)?.map { it.toUiDiscography() })
        }
    }

}