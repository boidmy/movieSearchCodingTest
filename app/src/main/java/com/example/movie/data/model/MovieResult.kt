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

    /*fun getDateFormat(): String {
        return try {
            if (repRlsDate.isNullOrEmpty()) {
                ""
            } else {
                val originalFormat = SimpleDateFormat("yyyyMMdd", Locale.KOREA)
                val format = SimpleDateFormat("yyyy.MM.dd", Locale.KOREA)
                val originalData = originalFormat.parse(repRlsDate)
                val formatDate = originalData?.let {
                    format.format(it)
                }
                formatDate ?: ""
            }
        } catch (e: ParseException) {
            ""
        }
    }*/

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
        val url = posters?.let {
            it.split("|").run {
                getOrNull(0)
            }
        }
        return url ?: ""
    }

    fun getDirector(): String {
        return directors?.director?.getOrNull(0)?.directorNm ?: ""
    }
}