package com.example.movie.data.api

import com.example.movie.data.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET(
        "openapi-data2/wisenut/search_api/search_json2.jsp?" +
                "collection=kmdb_new2&detail=Y&ServiceKey=82DF87APR03O2O6B9MBE&listCount=10"
    )
    fun getMovieData(
        @Query("query") query: String,
        @Query("startCount") startCount: Int
    ): Observable<Movie>
}