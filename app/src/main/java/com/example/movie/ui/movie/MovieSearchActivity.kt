package com.example.movie.ui.movie

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.movie.R
import com.example.movie.databinding.ActivitySearchMovieBinding
import com.example.movie.extensions.ActionManager
import com.example.movie.extensions.toast
import com.example.movie.ui.ViewModelFactory
import com.example.movie.ui.base.BaseActivity
import com.example.movie.ui.movie.list.MovieAdapter
import kotlinx.android.synthetic.main.activity_search_movie.*
import javax.inject.Inject

class MovieSearchActivity : BaseActivity<ActivitySearchMovieBinding>() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var movieAdapter: MovieAdapter
    private val viewModel by viewModels<MovieSearchViewModel> { viewModelFactory }

    override val layout: Int
        get() = R.layout.activity_search_movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
        observe()
    }

    private fun bind() {
        binding.apply {
            vm = viewModel
            movieRv.adapter = movieAdapter
        }
    }

    private fun observe() {
        ActionManager.loadingImg.observe(this, {
            progressContainer.isVisible = it
        })

        viewModel.item.observe(this, {
            it.first?.let { movie ->
                movieAdapter.setMovieData(movie = movie, loadMoreCheck = it.second)
            }
        })

        viewModel.emptyKeyword.observe(this, {
            if (it) {
                this.toast(resources.getString(R.string.search_hint))
            }
        })
    }
}