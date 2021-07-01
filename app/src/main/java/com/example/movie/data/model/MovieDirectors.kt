package com.example.movie.data.model
import com.google.gson.annotations.SerializedName

data class MovieDirectors(
    @SerializedName("director")
    val director: List<Director>?
)

data class Director(
    @SerializedName("directorEnNm")
    val directorEnNm: String?,
    @SerializedName("directorId")
    val directorId: String?,
    @SerializedName("directorNm")
    val directorNm: String?
)