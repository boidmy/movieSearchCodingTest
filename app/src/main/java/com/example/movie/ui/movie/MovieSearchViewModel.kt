package com.example.movie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.movie.data.model.Movie
import com.example.movie.data.model.MovieResult
import com.example.movie.data.movie.MovieRepository
import com.example.movie.di.custom.ActivityScope
import javax.inject.Inject

class MovieSearchViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    private val _loadingImg: MutableLiveData<Boolean> = MutableLiveData()
    private val _searchKeyword: MutableLiveData<Pair<String, Int>> = MutableLiveData()
    private val _movieList: MutableList<MovieResult> = mutableListOf()
    private val _item: LiveData<Movie> = Transformations.switchMap(_searchKeyword) {
        _loadingImg.value = true
        repository.getMovieList(keyword = it.first, startCount = it.second)
    }
    private val _emptyKeyword: MutableLiveData<Boolean> = MutableLiveData()

    val loadingImg: MutableLiveData<Boolean>
        get() = _loadingImg

    val item: LiveData<Movie>
        get() = _item

    val emptyKeyword: LiveData<Boolean>
        get() = _emptyKeyword

    val movieList: MutableList<MovieResult>
        get() = _movieList

    fun clickSearch(keyword: String) {
        _movieList.clear()
        _emptyKeyword.value = keyword.isEmpty()
        if (keyword.isNotEmpty())
            _searchKeyword.value = Pair(keyword, 0)
    }

    fun loadMore(itemCount: Int) {
        _searchKeyword.apply {
            value?.first?.let { keyword ->
                value = Pair(keyword, itemCount)
            }
        }
    }
}