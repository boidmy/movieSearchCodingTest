package com.example.movie.ui.movie

interface MovieController {

    fun loadMore(itemCount: Int)
    fun getItemTotalCount(): Int?
    fun clickSearch(keyword: String)
}