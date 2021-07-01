package com.example.movie.ui.movie

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.movie.R
import com.example.movie.databinding.ActivitySearchMovieBinding
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
        binding.viewModel = viewModel
        bind()
        observe()
    }

    private fun bind() {
        binding.movieRv.apply {
            adapter = movieAdapter
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        }
        listLoadMore()
    }

    private fun observe() {
        viewModel.loadingImg.observe(this, {
            progressContainer.isVisible = it
        })

        viewModel.item.observe(this, {
            viewModel.loadingImg.value = false
            movieAdapter.setMovieData(it.movieResult(viewModel.movieList))
        })

        viewModel.emptyKeyword.observe(this, {
            this.toast(resources.getString(R.string.search_hint))
        })
    }

    private fun listLoadMore() {
        binding.movieRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val itemCount = binding.movieRv.layoutManager?.itemCount ?: 0
                if (!recyclerView.canScrollVertically(1)) {
                    viewModel.item.value?.data?.getOrNull(0)?.totalCount?.let {
                        if (itemCount < it && itemCount < 100) {
                            viewModel.loadMore(itemCount)
                        }
                    }
                }
            }
        })
    }
}