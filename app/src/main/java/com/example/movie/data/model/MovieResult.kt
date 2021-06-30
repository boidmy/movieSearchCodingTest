package com.example.movie.data.model
import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("modDate")
    val modDate: String?,
    @SerializedName("movieId")
    val movieId: String?,
    @SerializedName("movieSeq")
    val movieSeq: String?,
    @SerializedName("nation")
    val nation: String?,
    @SerializedName("openThtr")
    val openThtr: String?,
    @SerializedName("posters")
    val posters: String?,
    @SerializedName("prodYear")
    val prodYear: String?,
    @SerializedName("ratedYn")
    val ratedYn: String?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("regDate")
    val regDate: String?,
    @SerializedName("repRatDate")
    val repRatDate: String?,
    @SerializedName("repRlsDate")
    val repRlsDate: String?,
    @SerializedName("releaseDate")
    val releaseDate: String?,
    @SerializedName("runtime")
    val runtime: String?,
    @SerializedName("salesAcc")
    val salesAcc: String?,
    @SerializedName("screenArea")
    val screenArea: String?,
    @SerializedName("screenCnt")
    val screenCnt: String?,
    @SerializedName("soundtrack")
    val soundtrack: String?,
    @SerializedName("statDate")
    val statDate: String?,
    @SerializedName("statSouce")
    val statSouce: String?,
    @SerializedName("stlls")
    val stlls: String?,
    @SerializedName("themeSong")
    val themeSong: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("titleEng")
    val titleEng: String?,
    @SerializedName("titleEtc")
    val titleEtc: String?,
    @SerializedName("titleOrg")
    val titleOrg: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("use")
    val use: String?,
)