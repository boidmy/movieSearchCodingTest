package com.example.movie.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R

class SearchMovieAdapter : RecyclerView.Adapter<SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_grid_item, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindView()
    }

    override fun getItemCount(): Int {
        return 50
    }
}

class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindView() {

    }
}