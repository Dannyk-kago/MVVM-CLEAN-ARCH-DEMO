package com.developerdan.mvvmcleanarchdemo.domain.use_case.get_coins

import com.developerdan.mvvmcleanarchdemo.data.remote.dto.toMovie
import com.developerdan.mvvmcleanarchdemo.domain.model.Movie
import com.developerdan.mvvmcleanarchdemo.domain.repository.MovieRepository
import com.developerdan.mvvmcleanarchdemo.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
){
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading<List<Movie>>())
            val coins = repository.getMovies().map {it.toMovie()}
            emit(Resource.Success<List<Movie>>(coins))
        } catch (e: HttpException){
            emit(Resource.Error<List<Movie>>(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Movie>>("Couldn't reach server. Check your internet connection"))
        }
    }
}