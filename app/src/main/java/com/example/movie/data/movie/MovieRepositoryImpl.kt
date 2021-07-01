package com.example.movie.data.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.data.api.ApiConnection
import com.example.movie.data.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor() : MovieRepository {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun getMovieList(query: String, startCount: Int): LiveData<Movie> {
        val liveData: MutableLiveData<Movie> = MutableLiveData()
        disposable.add(
            ApiConnection.instance()
                .retrofitService.getMovieData(query, startCount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    liveData.value = it
                }, {
                    Log.d("error", it.toString())
                })
        )
        return liveData
    }
}