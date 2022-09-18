package com.famileo.myartist.domain.repositories

import com.famileo.myartist.domain.models.ArtistData

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


}