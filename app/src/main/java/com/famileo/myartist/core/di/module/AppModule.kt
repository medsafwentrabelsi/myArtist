package com.famileo.myartist.core.di.module

import android.app.Application
import android.content.Context
import com.famileo.myartist.core.MyArtistApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun bindsApplicationContext(application: MyArtistApplication?): Context

    @Binds
    abstract fun bindsApplication(application: Application?): Application
}