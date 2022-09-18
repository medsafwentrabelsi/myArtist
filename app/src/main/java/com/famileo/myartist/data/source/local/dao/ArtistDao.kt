package com.famileo.myartist.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.famileo.myartist.data.model.ArtistEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO, for [ArtistEntity] objects.
 */
@Dao
interface ArtistDao {

    /**
     * Insert Artists.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtist(artistEntity: Collection<ArtistEntity>)

    /**
     * Get all artists.
     */
    @Query("SELECT * FROM artist")
    fun getArtists(): Flow<List<ArtistEntity>>

    /**
     * Deletes the Artist table.
     */
    @Query("DELETE FROM artist")
    suspend fun deleteAllArtist()

    /**
     * Updates the artists list.
     */
    @Transaction
    suspend fun updateArtistList(artistEntity: Collection<ArtistEntity>) {
        deleteAllArtist()
        insertArtist(artistEntity)
    }
}