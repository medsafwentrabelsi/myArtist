package com.famileo.myartist.domain.usescases


import com.famileo.myartist.data.model.ArtistEntity
import com.famileo.myartist.domain.repositories.MyArtistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * GetArtistsUseCase get all artists from local data base.
 */
class GetArtistsUseCase @Inject constructor(
    private val myArtistRepository: MyArtistRepository
) {
    suspend operator fun invoke(): Flow<List<ArtistEntity>> {
        return myArtistRepository.getArtists()
    }
}