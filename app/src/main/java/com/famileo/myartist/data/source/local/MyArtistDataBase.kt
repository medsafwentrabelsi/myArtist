package com.famileo.myartist.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.famileo.myartist.data.model.ArtistEntity
import com.famileo.myartist.data.source.local.dao.ArtistDao

/**
 * Main application database.
 */
@Database(
    entities = [
        ArtistEntity::class,
    ],
    version = 1,
    exportSchema = true
)
abstract class MyArtistDataBase : RoomDatabase() {
    abstract fun artistDao(): ArtistDao

}
