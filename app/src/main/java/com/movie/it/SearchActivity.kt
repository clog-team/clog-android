package com.movie.it

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.movie.it.databinding.ActivitySearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity() {

    private var _binding: ActivitySearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        binding.apply {
            movieSearchView.isSubmitButtonEnabled = true
            movieSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    makeMovieSearchRequest("$query")
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })

            resultMoviesRecyclerView.layoutManager = LinearLayoutManager(this@SearchActivity)
            resultMoviesRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    this@SearchActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
            val adapter = MovieAdapter()
            adapter.itemClickListener = object : MovieAdapter.OnItemClickListener {
                override fun onItemClick(movie: Movie) {
                    val intent = Intent(this@SearchActivity, MovieDetailActivity::class.java)
                    intent.putExtra("movie", movie)
                    startActivity(intent)
                }
            }
            resultMoviesRecyclerView.adapter = adapter
        }
    }

    fun makeMovieSearchRequest(movieName: String) {
        val service = ApiService.create()
        val call = service.searchMovie(movieName)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies = response.body()?.items ?: return
                val adapter = binding.resultMoviesRecyclerView.adapter as MovieAdapter
                adapter.submitList(movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("movieit", "${t.message}")
            }
        })
    }

}