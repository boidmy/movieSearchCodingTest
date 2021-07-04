package com.example.movie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.movie.data.model.Movie
import com.example.movie.data.movie.MovieRepository
import javax.inject.Inject

class MovieSearchViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel(), MovieController {

    private val _searchKeyword: MutableLiveData<Pair<String, Int>> = MutableLiveData(Pair("아이언맨",0))
    private val _item: LiveData<Pair<Movie?, Boolean>> = Transformations.switchMap(_searchKeyword) {
        repository.getMovieList(keyword = it.first, startCount = it.second)
    }
    private val _emptyKeyword: MutableLiveData<Boolean> = MutableLiveData()

    val item: LiveData<Pair<Movie?, Boolean>>
        get() = _item

    val emptyKeyword: LiveData<Boolean>
        get() = _emptyKeyword

    override fun getItemCount() = item.value?.first?.totalCount

    override fun clickSearch(keyword: String) {
        _emptyKeyword.value = keyword.isEmpty()
        if (keyword.isNotEmpty())
            _searchKeyword.value = Pair(keyword, 0)
    }

    override fun loadMore(itemCount: Int) {
        _searchKeyword.apply {
            value?.first?.let { keyword ->
                value = Pair(keyword, itemCount)
            }
        }
    }

    override fun onCleared() {
        repository.onCleared()
        super.onCleared()
    }
}