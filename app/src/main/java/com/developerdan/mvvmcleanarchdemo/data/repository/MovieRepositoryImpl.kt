package com.developerdan.mvvmcleanarchdemo.data.repository

import com.developerdan.mvvmcleanarchdemo.data.remote.MovieApi
import com.developerdan.mvvmcleanarchdemo.data.remote.dto.MovieDto
import com.developerdan.mvvmcleanarchdemo.domain.repository.MovieRepository
import javax.inject.Inject

//Implementing the MovieRepository
class MovieRepositoryImpl @Inject constructor(
    //Private Immutable variable api that inherits from MovieApi
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getMovies(): List<MovieDto> {
        return api.getMovies()
    }

}