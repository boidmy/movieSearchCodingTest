package com.example.movie.ui.movie

import android.os.Bundle
import androidx.activity.viewModels
import com.example.movie.R
import com.example.movie.databinding.ActivitySearchMovieBinding
import com.example.movie.ui.ViewModelFactory
import com.example.movie.ui.base.BaseActivity
import javax.inject.Inject

class MovieSearchActivity : BaseActivity<ActivitySearchMovieBinding>() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<MovieSearchViewModel> { viewModelFactory }

    override val layout: Int
        get() = R.layout.activity_search_movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}