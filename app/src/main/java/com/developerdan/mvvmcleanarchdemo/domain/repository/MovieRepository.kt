package com.developerdan.mvvmcleanarchdemo.domain.repository

import com.developerdan.mvvmcleanarchdemo.data.remote.dto.MovieDto


interface MovieRepository {

    suspend fun getMovies(): List<MovieDto>

}