package com.developerdan.mvvmcleanarchdemo.presentation.movie_list

import com.developerdan.mvvmcleanarchdemo.domain.model.Movie


data class MovieListState(
    val isLoading: Boolean = false,
    val movie: List<Movie> = emptyList(),
    val error: String = ""
)
