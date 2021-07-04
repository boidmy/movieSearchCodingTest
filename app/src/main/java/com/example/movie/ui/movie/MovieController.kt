package com.example.movie.ui.movie

interface MovieController {

    fun loadMore(itemCount: Int)
    fun getItemCount(): Int?
    fun clickSearch(keyword: String)
}