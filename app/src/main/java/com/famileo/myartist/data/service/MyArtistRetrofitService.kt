package com.famileo.myartist.data.service

import com.famileo.myartist.data.model.WsArtists
import com.famileo.myartist.data.model.WsArtistsDiscography
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * MyArtistRetrofitService retrofit service declaration contain the MusicBrainz root.
 */
interface MyArtistRetrofitService {
    @GET("artist/")
    suspend fun fetchArtists(@Query("query") artistName: String, @Query("fmt") type: String = "json"): WsArtists

    @GET("artist/{id}")
    suspend fun fetchArtistDetails(
        @Path("id") artistId: String,
        @Query("fmt") type: String = "json",
        @Query("inc") inc: String = "release-groups"
    ): WsArtistsDiscography


    companion object {
        /** MusicBrainz API base URL.  */
        const val BASE_URL = "https://musicbrainz.org/ws/2/"
    }
}
