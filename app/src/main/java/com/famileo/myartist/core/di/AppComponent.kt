package com.famileo.myartist.core.di

import com.famileo.myartist.core.MyArtistApplication
import com.famileo.myartist.core.di.module.AppModule
import com.famileo.myartist.core.di.module.DatabaseModule
import com.famileo.myartist.core.di.module.MyArtistModule
import com.famileo.myartist.core.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        MyArtistModule::class


    ]
)
internal interface AppComponent : AndroidInjector<MyArtistApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: MyArtistApplication): AppComponent
    }
}