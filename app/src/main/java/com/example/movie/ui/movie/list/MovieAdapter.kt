package com.example.movie.ui.movie.list

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.common.DiffUtilCallBack
import com.example.movie.common.DiffUtilDataInterface
import com.example.movie.data.model.Movie
import com.example.movie.data.model.MovieResult
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieItemViewHolder>() {

    private val diffUtil = AsyncListDiffer(this, DiffUtilCallBack)

    private fun currentList(): MutableList<DiffUtilDataInterface> = diffUtil.currentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        currentList().getOrNull(position)?.let {
            holder.bindView(it as MovieResult)
        }
    }

    override fun getItemCount(): Int {
        return currentList().size
    }

    fun setMovieData(movie: Movie, loadMoreCheck: Boolean) {
        diffUtil.submitList(
            if (loadMoreCheck) setLoadMore(movie.getResult())
            else movie.getResult()
        )
    }

    private fun setLoadMore(item: List<DiffUtilDataInterface>): List<DiffUtilDataInterface> {
        val newItem = ArrayList(currentList())
        newItem.addAll(item)
        return newItem
    }
}