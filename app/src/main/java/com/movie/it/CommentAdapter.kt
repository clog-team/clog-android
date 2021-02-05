package com.movie.it

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class CommentAdapter : ListAdapter<Comment, CommentAdapter.CommentViewHolder>(DiffCallback) {

    val level = listOf(
        "누구냐 넌?!",
        "밥은 먹고 다니냐",
        "헤이 브라더!",
        "그대 눈동자에 건배",
        "내안에 너있다",
    )

    object DiffCallback : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem.comment == newItem.comment
        }
    }

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val commentTextView: TextView = itemView.findViewById(R.id.commentTextView)
        val friendNameTextView: TextView = itemView.findViewById(R.id.friend_item_name)
        val friendLevelTextView: TextView = itemView.findViewById(R.id.friend_item_level)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
    )

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = currentList[position]
        holder.ratingBar.rating = Random.nextInt(6, 10).toFloat() / 2
        holder.friendNameTextView.text = comment.username
        holder.friendLevelTextView.text = level[Random.nextInt(0, 5)]
        holder.commentTextView.text = comment.comment
    }
}