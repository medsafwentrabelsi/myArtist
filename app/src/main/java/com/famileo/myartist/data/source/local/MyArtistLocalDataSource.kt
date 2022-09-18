package com.famileo.myartist.data.source.local

import com.famileo.myartist.data.model.ArtistEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * MyArtistLocalDataSource related data local data source.
 */
class MyArtistLocalDataSource @Inject constructor(
    /** My artist data base. */
    private val myArtistDataBase: MyArtistDataBase,
) {
    fun getArtists(): Flow<List<ArtistEntity>> {
        return myArtistDataBase.artistDao().getArtists()
    }

    suspend fun insertArtists(artistEntityCollection: List<ArtistEntity>) {
        return myArtistDataBase.artistDao().updateArtistList(artistEntityCollection)
    }
}