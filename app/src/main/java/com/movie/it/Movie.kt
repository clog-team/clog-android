package com.movie.it

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Movie(
    @SerializedName("movieCode")
    val movieCode: String,
    @SerializedName("thumbnailUrl")
    val thumbnail: String,
    @SerializedName("movie_name")
    val movieName: String,
    @SerializedName("directors")
    val director: List<Director>,
    @SerializedName("opening_date")
    val openingDate: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("running_time")
    val runningTime: Int,
    @SerializedName("rating")
    val rating: String = "0.0"
) : Serializable {
    override fun equals(other: Any?): Boolean {
        (other as? Movie)?.let {
            return it.movieCode == other.movieCode
        } ?: return super.equals(other)
    }

    override fun hashCode(): Int {
        return Objects.hash(this.movieCode)
    }
}
