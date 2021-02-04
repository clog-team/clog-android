package com.movie.it

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface ApiService {
    @POST("movie/recent")
    fun getRecentMovies(): Call<List<Movie>>

    companion object {
        private const val BASE_URL = "http://localhost:8000/"

        fun create(): ApiService {
            val logger = HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}