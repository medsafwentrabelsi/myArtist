package com.famileo.myartist.domain.repositories

import com.famileo.myartist.domain.models.ArtistData
import com.famileo.myartist.domain.models.ArtistDiscographyData

/**
 * MyArtist related repository.
 */
interface MyArtistRepository {

    /**
     * Retrieves artists from the MusicBrainz api.
     *
     * @return a result, containing all artist.
     */
    suspend fun fetchArtists(artistName: String): List<ArtistData>?

    /**
     * Retrieves artist details from the MusicBrainz api.
     *
     * @return a result, containing artist details.
     */
    suspend fun fetchArtistDetails(artistId: String): List<ArtistDiscographyData>?

}