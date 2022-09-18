package com.famileo.myartist.data.repository

import com.famileo.myartist.data.model.toArtistData
import com.famileo.myartist.data.model.toArtistDiscographyData
import com.famileo.myartist.data.source.MyArtistRemoteDataSource
import com.famileo.myartist.domain.models.ArtistData
import com.famileo.myartist.domain.models.ArtistDiscographyData
import com.famileo.myartist.domain.repositories.MyArtistRepository
import javax.inject.Inject

/**
 * MyArtistRepository implementation.
 * */
class MyArtistRepositoryImpl @Inject constructor(
    private val myArtistRemoteDataSource: MyArtistRemoteDataSource
) : MyArtistRepository {

    override suspend fun fetchArtists(artistName: String): List<ArtistData>? {
        return myArtistRemoteDataSource.fetchArtist(artistName = artistName)?.artists?.map {
            it.toArtistData()
        }
    }

    override suspend fun fetchArtistDetails(artistId: String): List<ArtistDiscographyData>? {
        return myArtistRemoteDataSource.fetchArtistDetails(artistId = artistId)?.wsDiscography?.map {
            it.toArtistDiscographyData()
        }
    }
}