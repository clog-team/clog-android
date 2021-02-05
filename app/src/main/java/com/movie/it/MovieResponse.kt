package com.movie.it

import com.google.gson.annotations.SerializedName

data class MovieResponse(@SerializedName("items") val items: List<Movie>)
