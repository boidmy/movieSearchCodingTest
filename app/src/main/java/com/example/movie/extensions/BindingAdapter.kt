package com.example.movie.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.BindingAdapter
import com.example.movie.ui.movie.MovieSearchViewModel


@BindingAdapter("editTextAction")
fun editTextAction(editText: EditText, viewModel: MovieSearchViewModel) {
    editText.setOnEditorActionListener(OnEditorActionListener { v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            clickSearch(editText, viewModel)
            return@OnEditorActionListener true
        }
        false
    })
}

@BindingAdapter("imageAction", "movieViewModel")
fun imageAction(imageView: ImageView, editText: EditText, viewModel: MovieSearchViewModel) {
    imageView.setOnClickListener {
        clickSearch(editText, viewModel)
    }
}

@BindingAdapter("imageUrl")
fun imageUrl(imageView: ImageView, url: String?) {
    imageView.loadUrl(url)
}

fun clickSearch(editText: EditText, viewModel: MovieSearchViewModel) {
    viewModel.clickSearch(editText.text.toString())
    focusAndKeyboardHide(editText)
}

fun focusAndKeyboardHide(view: View) {
    val inputMethodManager =
        view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}