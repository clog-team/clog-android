package com.movie.it

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.movie.it.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private var _binding: ActivityMovieDetailBinding? = null
    private val binding get() = _binding!!
    lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)

        movie = intent.getSerializableExtra("movie") as? Movie ?: return
        Log.d("movieit", "$movie")

        binding.apply {
            Glide.with(this@MovieDetailActivity).load(movie.thumbnail).into(movieThumbnail)
            openDateTextView.text = movie.openingDate
            movieNameTextView.text = movie.movieName
            directorTextView.text =
                if (movie.director.isEmpty()) "" else movie.director.first().name
            genreTextView.text = movie.genre
        }
    }
}