package com.famileo.myartist.data.source

import com.famileo.myartist.data.model.WsArtists
import com.famileo.myartist.data.model.WsArtistsDiscography
import com.famileo.myartist.data.service.MyArtistRetrofitService
import timber.log.Timber
import javax.inject.Inject

/**
 * MyArtistRemoteDataSource related data network data source.
 */
class MyArtistRemoteDataSource @Inject constructor(
    /** MusicBrainz API service. */
    private val retrofitService: MyArtistRetrofitService,
) {
    suspend fun fetchArtist(artistName: String): WsArtists? {
        return try {
            retrofitService.fetchArtists(artistName = artistName)
        } catch (e: Exception) {
            Timber.w(e, "An exception occurred during the web service call")
            null
        }
    }

    suspend fun fetchArtistDetails(artistId: String): WsArtistsDiscography? {
        return try {
            retrofitService.fetchArtistDetails(artistId = artistId)
        } catch (e: Exception) {
            Timber.w(e, "An exception occurred during the web service call")
            null
        }
    }
}