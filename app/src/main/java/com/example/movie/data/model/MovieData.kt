package com.example.movie.data.model
import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("CollName")
    val collName: String?,
    @SerializedName("Count")
    val count: Int?,
    @SerializedName("Result")
    val result: List<MovieResult>?,
    @SerializedName("TotalCount")
    val totalCount: Int?
)