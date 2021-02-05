package com.movie.it

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieThumbnailAdapter :
    ListAdapter<Movie, MovieThumbnailAdapter.MovieThumbnailViewHolder>(DiffCallback) {

    lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(movie: Movie)
    }

    object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.movieName == newItem.movieName
        }
    }

    inner class MovieThumbnailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnailView: ImageView = itemView.findViewById(R.id.movieThumbnail)

        init {
            itemView.setOnClickListener {
                itemClickListener.onItemClick(currentList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieThumbnailViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_thumbnail_item, parent, false)
    )

    override fun onBindViewHolder(holder: MovieThumbnailViewHolder, position: Int) {
        val movie = currentList[position]

        Glide.with(holder.itemView.context)
            .load(movie.thumbnail)
            .into(holder.thumbnailView)
    }
}