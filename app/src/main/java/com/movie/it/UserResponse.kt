package com.movie.it

import com.google.gson.annotations.SerializedName

data class UserResponse(@SerializedName("result") val result: List<User>)
