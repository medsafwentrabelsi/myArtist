package com.famileo.myartist.core.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Network related injection module.
 */
@Module
class NetworkModule {


    /**
     * Provides a basic [OkHttpClient.Builder] instance, with timeouts already set.
     */
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .header("User-Agent", "Famileo")
                        .build()
                )
            }
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })



        return builder
    }

}