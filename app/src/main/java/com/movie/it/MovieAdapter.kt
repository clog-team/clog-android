package com.movie.it

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.movieName == newItem.movieName
        }
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnailView: ImageView = itemView.findViewById(R.id.movieThumbnail)
        val movieNameTextView: TextView = itemView.findViewById(R.id.movieNameTextView)
        val directorTextView: TextView = itemView.findViewById(R.id.directorTextView)
        val openDateTextView: TextView = itemView.findViewById(R.id.openDateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
    )


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = currentList[position]

        Glide.with(holder.itemView.context)
            .load(movie.thumbnail)
            .into(holder.thumbnailView)

        holder.apply {
            movieNameTextView.text = movie.movieName
            val directors = movie.director
            Log.d("movieit", "$directors")
            directorTextView.text = if (directors.isEmpty()) "" else directors.first().name
            openDateTextView.text = movie.openingDate
        }
    }
}