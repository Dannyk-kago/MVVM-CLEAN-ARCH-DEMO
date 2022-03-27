package com.developerdan.mvvmcleanarchdemo.presentation.movie_list.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.developerdan.mvvmcleanarchdemo.domain.model.Movie


@Composable
fun MovieItem(
    movie: Movie
) {
     Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 2.dp, start = 2.dp, end = 2.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier.padding(2.dp),
                Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                val movieImg = movie.imageUrl
                val painter = rememberImagePainter(
                    data = movieImg,
                    builder = {
                        transformations(
                            CircleCropTransformation()
                        )
                    }
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }
            Column(
                modifier = Modifier.padding(2.dp),
                Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Movie Info:")
                Text(text = "Name: ${movie.name}")
                Text(text = "Category: ${movie.category}")
            }
        }
    }
}

