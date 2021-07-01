package com.example.movie.data.model
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Data")
    val data: List<MovieData>?,
    @SerializedName("KMAQuery")
    val kMAQuery: String?,
    @SerializedName("Query")
    val query: String?,
    @SerializedName("TotalCount")
    val totalCount: Int?
) {
    fun movieResult(movieList: MutableList<MovieResult>): MutableList<MovieResult> {
        data?.getOrNull(0)?.result?.let {
            movieList.addAll(it)
        }
        return movieList
    }
}