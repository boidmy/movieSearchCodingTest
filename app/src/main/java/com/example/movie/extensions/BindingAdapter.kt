package com.example.movie.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.ui.movie.MovieController

@BindingAdapter("movieLoadMore")
fun movieLoadMore(rv: RecyclerView, viewModel: MovieController?) {
    rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            with(recyclerView) {
                super.onScrolled(this, dx, dy)
                if (!canScrollVertically(1)) {
                    layoutManager?.itemCount?.let { rvCount ->
                        viewModel?.getItemTotalCount()?.let { totalCount ->
                            if (rvCount < totalCount && rvCount < 100) {
                                viewModel.loadMore(rvCount)
                            }
                        }
                    }
                }
            }
         }
    })
}

@BindingAdapter("editTextAction")
fun editTextAction(editText: EditText, viewModel: MovieController?) {
    editText.setOnEditorActionListener(OnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            clickSearch(editText, viewModel)
            return@OnEditorActionListener true
        }
        false
    })
}

@BindingAdapter("imageAction", "movieViewModel")
fun imageAction(imageView: ImageView, editText: EditText, viewModel: MovieController?) {
    imageView.setOnClickListener {
        clickSearch(editText, viewModel)
    }
}

@BindingAdapter("imageUrl")
fun imageUrl(imageView: ImageView, url: String?) {
    imageView.loadUrl(url)
}

fun clickSearch(editText: EditText, viewModel: MovieController?) {
    viewModel?.clickSearch(editText.text.toString())
    focusAndKeyboardHide(editText)
}

fun focusAndKeyboardHide(view: View) {
    val inputMethodManager =
        view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}