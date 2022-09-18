package com.famileo.myartist.data.repository

import com.famileo.myartist.data.model.ArtistEntity
import com.famileo.myartist.data.model.toArtistDiscographyData
import com.famileo.myartist.data.model.toArtistEntity
import com.famileo.myartist.data.source.MyArtistRemoteDataSource
import com.famileo.myartist.data.source.local.MyArtistLocalDataSource
import com.famileo.myartist.domain.models.ArtistDiscographyData
import com.famileo.myartist.domain.repositories.MyArtistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * MyArtistRepository implementation.
 * */
class MyArtistRepositoryImpl @Inject constructor(
    private val myArtistRemoteDataSource: MyArtistRemoteDataSource,
    private val myArtistLocalDataSource: MyArtistLocalDataSource
) : MyArtistRepository {

    override suspend fun fetchArtists(artistName: String) {
        val result = myArtistRemoteDataSource.fetchArtist(artistName = artistName)?.artists
        result?.map {
            it.toArtistEntity()
        }?.let {
            myArtistLocalDataSource.insertArtists(it)
        }
    }

    override suspend fun fetchArtistDetails(artistId: String): List<ArtistDiscographyData>? {
        return myArtistRemoteDataSource.fetchArtistDetails(artistId = artistId)?.wsDiscography?.map {
            it.toArtistDiscographyData()
        }
    }

    override suspend fun getArtists(): Flow<List<ArtistEntity>> {
        return myArtistLocalDataSource.getArtists()
    }
}