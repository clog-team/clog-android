package com.movie.it

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.movie.it.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private var _binding: ActivityMovieDetailBinding? = null
    private val binding get() = _binding!!
    lateinit var movie: Movie
    val dummyComments = listOf(
        "짱재애ㅐ애앰ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ",
        "감동적이어서 눈물이 콸콸콸ㅠ",
        "이거 개꿀잼 ㅇㅈ",
        "걍 볼만한듯?",
        "인생영화다 ㄹㅇ",
        "재밌네요 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ",
        "goooooooooooooooooooooooooooood~~"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)

        movie = intent.getSerializableExtra("movie") as? Movie ?: return

        binding.apply {
            Glide.with(this@MovieDetailActivity).load(movie.thumbnail).into(movieThumbnail)
            openDateTextView.text = movie.openingDate
            movieNameTextView.text = movie.movieName
            directorTextView.text =
                if (movie.director.isEmpty()) "" else movie.director.first().name
            genreTextView.text = movie.genre

            commentRecyclerView.layoutManager = LinearLayoutManager(this@MovieDetailActivity)
            commentRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    this@MovieDetailActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
            commentRecyclerView.adapter = CommentAdapter()
        }
    }

    override fun onResume() {
        super.onResume()
        getComment()
    }

    private fun getComment() {
        val users = listOf("김유진", "김채린", "신윤섭", "김민정", "이주영", "원빈", "이나영")
        val comments = mutableListOf<Comment>()
        for (i in users.indices) {
            if (users[i] == "김유진")
                continue

            comments += Comment(users[i], movie.movieCode, dummyComments[i])
        }
        val adapter = binding.commentRecyclerView.adapter as CommentAdapter
        adapter.submitList(comments)
    }
}