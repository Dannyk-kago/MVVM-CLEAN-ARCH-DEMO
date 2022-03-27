package com.developerdan.mvvmcleanarchdemo.di

import com.developerdan.mvvmcleanarchdemo.data.remote.MovieApi
import com.developerdan.mvvmcleanarchdemo.data.repository.MovieRepositoryImpl
import com.developerdan.mvvmcleanarchdemo.domain.repository.MovieRepository
import com.developerdan.mvvmcleanarchdemo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
    @Provides
    @Singleton
    fun provideCoinRepository(api:MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}