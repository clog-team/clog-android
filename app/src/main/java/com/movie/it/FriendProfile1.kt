package com.movie.it

import com.google.gson.annotations.SerializedName

data class FriendProfile(@SerializedName("items") val items: List<Movie>)
data class FriendProfile1(var img:Int, var username:String, var level:String, var prog:Int)