package com.movie.it

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Director(@SerializedName("peopleNm") val name: String) : Serializable
