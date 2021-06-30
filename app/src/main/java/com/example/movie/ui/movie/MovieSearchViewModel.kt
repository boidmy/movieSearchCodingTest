package com.example.movie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.movie.data.model.Movie
import com.example.movie.data.movie.MovieRepository
import javax.inject.Inject

class MovieSearchViewModel @Inject constructor(repository: MovieRepository) : ViewModel() {

    private val _searchKeyword: MutableLiveData<String> = MutableLiveData()
    val _item: LiveData<Movie> = Transformations.switchMap(searchKeyword) {
        repository.getMovieList(query = it)
    }

    val searchKeyword: LiveData<String>
        get() = _searchKeyword

    val item: LiveData<Movie>
        get() = _item
}