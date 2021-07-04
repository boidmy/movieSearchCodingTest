package com.example.movie.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R

fun ImageView.loadUrl(url: String?) {
    Glide.with(this)
        .load(if (url.isNullOrEmpty()) R.drawable.default_img else url)
        .apply(RequestOptions.errorOf(R.drawable.default_img))
        .into(this)
}