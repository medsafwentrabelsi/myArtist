package com.famileo.myartist.domain.usescases

import com.famileo.myartist.domain.models.ArtistDiscographyData
import com.famileo.myartist.domain.repositories.MyArtistRepository
import javax.inject.Inject

/**
 * FetchArtistDiscographyUseCase to fetch artist discography from server.
 */
class FetchArtistDiscographyUseCase @Inject constructor(
    private val myArtistRepository: MyArtistRepository
) {
    suspend operator fun invoke(artistId: String): List<ArtistDiscographyData>? {
        return myArtistRepository.fetchArtistDetails(artistId)
    }
}