package com.movie.it

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.movie.it.databinding.FragmentHomeBinding

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

            val recentMovies = listOf(
                Movie(
                    "1",
                    "https://t1.daumcdn.net/cfile/tistory/0138F14A517F77713A",
                    "",
                    listOf(Director("신윤섭")),
                    "",
                    "",
                    0
                ),
                Movie(
                    "12",
                    "https://i.ytimg.com/vi/5-mWvUR7_P0/maxresdefault.jpg",
                    "",
                    listOf(Director("신윤섭")),
                    "",
                    "",
                    0
                ),
            )
            setHorizontalRecyclerViewConfig(recentRecyclerView)
            val adapter = MovieThumbnailAdapter()
            adapter.itemClickListener = object : MovieThumbnailAdapter.OnItemClickListener {
                override fun onItemClick(movie: Movie) {
                    val intent = Intent(context, MovieDetailActivity::class.java)
                    intent.putExtra("movieCode", movie.movieCode)
                    startActivity(intent)
                }
            }
            adapter.submitList(recentMovies)
            recentRecyclerView.adapter = adapter

            setHorizontalRecyclerViewConfig(oldRecyclerView)
        }
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