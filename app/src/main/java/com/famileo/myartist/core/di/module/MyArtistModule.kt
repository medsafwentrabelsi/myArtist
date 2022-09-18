package com.famileo.myartist.core.di.module

import androidx.lifecycle.ViewModel
import com.famileo.myartist.core.di.annotations.ViewModelKey
import com.famileo.myartist.data.repository.MyArtistRepositoryImpl
import com.famileo.myartist.data.service.MyArtistRetrofitService
import com.famileo.myartist.domain.repositories.MyArtistRepository
import com.famileo.myartist.presentation.activity.MainActivity
import com.famileo.myartist.presentation.fragments.ArtistDetailsFragment
import com.famileo.myartist.presentation.fragments.ArtistListFragment
import com.famileo.myartist.presentation.viewmodels.ArtistsViewModel
import com.famileo.myartist.presentation.viewmodels.DiscographyViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * "My artist module" app module binding module.
 * */
@Module(includes = [MyArtistModule.Declarations::class])
class MyArtistModule {
    /** JSON parsing rules. */
    private val json = Json {
        ignoreUnknownKeys = true
    }

    /**
     * Provides a [MyArtistRetrofitService] instance.
     */
    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideMyArtistRetrofitService(okHttpClientBuilder: OkHttpClient.Builder, @Named(MUSIC_BRAINZ_KEY) baseUrl: String): MyArtistRetrofitService {

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClientBuilder.build())
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        return retrofit.create(MyArtistRetrofitService::class.java)
    }

    /**
     * Provides the base URL for the MUSICBRAINZ service.
     */
    @Provides
    @Named(MUSIC_BRAINZ_KEY)
    fun provideMusicBrainzBaseUrl(): String {
        return MyArtistRetrofitService.BASE_URL
    }


    @Module
    internal interface Declarations {
        // region Activities
        @ContributesAndroidInjector
        abstract fun bindMainActivity(): MainActivity

        // endregion

        // region Fragments

        @ContributesAndroidInjector
        abstract fun bindMArtistListFragment(): ArtistListFragment

        @ContributesAndroidInjector
        abstract fun bindMArtistDetailsFragment(): ArtistDetailsFragment

        // endregion


        @Binds
        abstract fun bindMyArtistRepository(impl: MyArtistRepositoryImpl): MyArtistRepository


        @Binds
        @IntoMap
        @ViewModelKey(ArtistsViewModel::class)
        abstract fun provideArtistsViewModel(viewModel: ArtistsViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(DiscographyViewModel::class)
        abstract fun provideDiscographyViewModel(viewModel: DiscographyViewModel): ViewModel

    }


}

const val MUSIC_BRAINZ_KEY = "MUSIC_BRAINZ_URL"
