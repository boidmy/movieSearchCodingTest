package com.example.movie.data.model

import com.example.movie.common.DiffUtilDataInterface
import com.google.gson.annotations.SerializedName
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

data class MovieResult(
    @SerializedName("DOCID")
    val docId: String?,
    @SerializedName("posters")
    val posters: String?,
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
    @SerializedName("directors")
    val directors: MovieDirectors?
) : DiffUtilDataInterface {
    override fun keyValue(): String {
        return docId ?: ""
    }

    override fun contentValue(): String {
        return title ?: ""
    }

    fun getDateFormat(): String {
        if (repRlsDate.isNullOrEmpty()) return ""
        return try {
            return SimpleDateFormat("yyyyMMdd", Locale.KOREA).run {
                parse(repRlsDate)
            }?.let {
                SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).run {
                    format(it)
                }
            } ?: ""
        } catch (e: ParseException) {
            ""
        }
    }

    fun getPoster(): String {
        return posters?.let {
            it.split("|").getOrNull(0)
        } ?: ""
    }

    fun getDirector(): String {
        return directors?.director?.getOrNull(0)?.directorNm ?: ""
    }

    fun getReplaceTitle(): String {
        return title
            ?.replace("!HS", "")
            ?.replace("!HE", "")
            ?.replace("  ", " ")
            ?: ""
    }
}