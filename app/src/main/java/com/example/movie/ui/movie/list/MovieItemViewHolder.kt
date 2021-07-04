package com.example.movie.ui.movie.list

import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.data.model.MovieResult
import com.example.movie.databinding.MovieGridItemBinding
import com.example.movie.ui.base.ViewHolderBase

class MovieItemViewHolder(parent: ViewGroup) :
    ViewHolderBase<MovieGridItemBinding>(parent, R.layout.movie_grid_item) {

    fun bindView(item: MovieResult) {
        binding.item = item
    }
}