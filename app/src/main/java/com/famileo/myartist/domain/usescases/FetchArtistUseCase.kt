package com.famileo.myartist.domain.usescases

import com.famileo.myartist.domain.repositories.MyArtistRepository
import javax.inject.Inject

/**
 * FetchArtistUseCase to fetch artist from server.
 */
class FetchArtistUseCase @Inject constructor(
    private val myArtistRepository: MyArtistRepository
) {
    suspend operator fun invoke(artistName: String) {
        myArtistRepository.fetchArtists(artistName)
    }
}