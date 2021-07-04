package com.example.movie.data.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.data.api.ApiConnection
import com.example.movie.data.model.Movie
import com.example.movie.extensions.ActionManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor() : MovieRepository {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun getMovieList(keyword: String, startCount: Int): LiveData<Pair<Movie?, Boolean>> {
        ActionManager.loadingImg.value = true
        val liveData: MutableLiveData<Pair<Movie?, Boolean>> = MutableLiveData()
        disposable.add(
            ApiConnection.instance()
                .retrofitService.getMovieData(keyword, startCount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ActionManager.loadingImg.value = false
                    liveData.value = Pair(it, startCount >= 10)
                }, {
                    ActionManager.loadingImg.value = false
                    Log.d("error", it.toString())
                })
        )
        return liveData
    }

    override fun onCleared() {
        disposable.dispose()
    }
}