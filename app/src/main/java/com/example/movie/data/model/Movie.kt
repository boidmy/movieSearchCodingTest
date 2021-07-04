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

    fun getResult(): List<MovieResult> {
        return data?.getOrNull(0)?.result ?: listOf()
    }
}