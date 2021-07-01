package com.example.movie.data.movie

import androidx.lifecycle.LiveData
import com.example.movie.data.model.Movie

interface MovieRepository {

    fun getMovieList(query: String, startCount: Int): LiveData<Movie>
}