package com.developerdan.mvvmcleanarchdemo.data.remote

import com.developerdan.mvvmcleanarchdemo.data.remote.dto.MovieDto
import retrofit2.http.GET

interface MovieApi {

    @GET("movielist.json")
    suspend fun getMovies(): List<MovieDto>

}