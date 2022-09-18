package com.famileo.myartist.core.di.module

import android.content.Context
import androidx.room.Room
import com.famileo.myartist.data.source.local.MyArtistDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Database related injection module.
 */
@Module
class DatabaseModule {
    /**
     * Provides the local database.
     */
    @Provides
    @Singleton
    fun provideDatabase(context: Context): MyArtistDataBase {
        val databaseBuilder = Room.databaseBuilder(context, MyArtistDataBase::class.java, "MyArtistDataBase-database")
        return databaseBuilder.build()
    }

}