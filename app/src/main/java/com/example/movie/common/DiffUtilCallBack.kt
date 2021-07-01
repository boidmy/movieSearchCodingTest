package com.example.movie.common

import androidx.recyclerview.widget.DiffUtil

object DiffUtilCallBack: DiffUtil.ItemCallback<DiffUtilDataInterface>() {
    override fun areItemsTheSame(oldItem: DiffUtilDataInterface, newItem: DiffUtilDataInterface): Boolean {
        return oldItem.keyValue() == newItem.keyValue()
    }

    override fun areContentsTheSame(
        oldItem: DiffUtilDataInterface,
        newItem: DiffUtilDataInterface
    ): Boolean {
        return oldItem.contentValue() == newItem.contentValue()
    }
}