package com.movie.it

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.movie.it.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()

        binding.apply {
            searchButton.setOnClickListener {
                val intent = Intent(context, SearchActivity::class.java)
                startActivity(intent)
            }


            setHorizontalRecyclerViewConfig(friendRecyclerView)
            val friendAdapter = MovieThumbnailAdapter()
            friendAdapter.itemClickListener = object : MovieThumbnailAdapter.OnItemClickListener {
                override fun onItemClick(movie: Movie) {
                    val intent = Intent(context, MovieDetailActivity::class.java)
                    intent.putExtra("movie", movie)
                    startActivity(intent)
                }
            }
            friendRecyclerView.adapter = friendAdapter


            setHorizontalRecyclerViewConfig(recentRecyclerView)
            val recentAdapter = MovieThumbnailAdapter()
            recentAdapter.itemClickListener = object : MovieThumbnailAdapter.OnItemClickListener {
                override fun onItemClick(movie: Movie) {
                    val intent = Intent(context, MovieDetailActivity::class.java)
                    intent.putExtra("movie", movie)
                    startActivity(intent)
                }
            }
            recentRecyclerView.adapter = recentAdapter


            setHorizontalRecyclerViewConfig(oldRecyclerView)
            val oldAdapter = MovieThumbnailAdapter()
            oldAdapter.itemClickListener = object : MovieThumbnailAdapter.OnItemClickListener {
                override fun onItemClick(movie: Movie) {
                    val intent = Intent(context, MovieDetailActivity::class.java)
                    intent.putExtra("movie", movie)
                    startActivity(intent)
                }
            }
            oldRecyclerView.adapter = oldAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        makeOldMoviesRequest()
        makeRecentMoviesRequest()
    }

    private fun makeRecentMoviesRequest() {
        val service = ApiService.create()
        val call = service.getRecentMovies()
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies = response.body()?.items ?: return
                val adapter = binding.recentRecyclerView.adapter as MovieThumbnailAdapter
                adapter.submitList(movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("movieit", "${t.message}")
            }
        })
    }

    private fun makeOldMoviesRequest() {
        val service = ApiService.create()
        val call = service.getOldMovies()
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies = response.body()?.items ?: return
                Log.d("movieit", "${movies}")
                val adapter = binding.oldRecyclerView.adapter as MovieThumbnailAdapter
                adapter.submitList(movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("movieit", "${t.message}")
            }
        })
    }

    private fun setHorizontalRecyclerViewConfig(recyclerView: RecyclerView) {
        val context = requireContext()
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.HORIZONTAL
            )
        )
    }
}