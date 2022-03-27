package com.developerdan.mvvmcleanarchdemo.data.remote.dto

import com.developerdan.mvvmcleanarchdemo.domain.model.Movie

//Data access object class
data class MovieDto(
    val category: String,
    val desc: String,
    val imageUrl: String,
    val name: String
)

//Mapping MovieDto to Movie
fun MovieDto.toMovie(): Movie {
   return Movie(
       category = category,
       desc = desc,
       imageUrl = imageUrl,
       name = name
   )
}