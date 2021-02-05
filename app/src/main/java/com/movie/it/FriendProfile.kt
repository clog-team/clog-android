package com.movie.it

import android.widget.ProgressBar

data class FriendProfile(var img:Int,var name:String,var level:String,var prog:Int)
//@GET("user/")
//fun getRecentMovies(): Call<List<FriendProfile>>
//
//companion object {
//    private const val BASE_URL = "http://10.0.2.2:8000/"
//    fun create(): ApiService {
//        val logger = HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BASIC }
//        val client = OkHttpClient.Builder()
//            .addInterceptor(logger)
//            .build()
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//}