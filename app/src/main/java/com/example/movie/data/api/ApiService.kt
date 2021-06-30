package com.example.movie.data.api

import com.example.movie.data.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("collection=kmdb_new2&detail=Y&ServiceKey=82DF87APR03O2O6B9MBE&listCount=100")
    fun getMovieData(@Query("query") query: String): Observable<Movie>
}