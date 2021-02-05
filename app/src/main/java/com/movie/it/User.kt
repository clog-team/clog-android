package com.movie.it

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("url") val url: String,
    @SerializedName("username") val username: String,
)
