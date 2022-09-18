package com.famileo.myartist.domain.repositories

import com.famileo.myartist.data.model.ArtistEntity
import com.famileo.myartist.domain.models.ArtistDiscographyData
import kotlinx.coroutines.flow.Flow

/**
 * MyArtist related repository.
 */
interface MyArtistRepository {

    /**
     * Retrieves artists from the MusicBrainz api.
     */
    suspend fun fetchArtists(artistName: String)

    /**
     * Retrieves artist details from the MusicBrainz api.
     *
     * @return a result, containing artist details.
     */
    suspend fun fetchArtistDetails(artistId: String): List<ArtistDiscographyData>?

    /**
     * Retrieves artists from local data base.
     *
     * @return a result, containing artists.
     */
    suspend fun getArtists(): Flow<List<ArtistEntity>>

}