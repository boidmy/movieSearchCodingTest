package com.example.movie.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnection {

    private val retrofit: Retrofit

    private val baseUrl = "https://datewidget-ab4ba.firebaseio.com/"

    private val retrofitService: ApiConnection
        get() = retrofit.create(ApiConnection::class.java)

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    companion object {

        private val INSTANCE = ApiConnection()

        fun instance(): ApiConnection {
            return INSTANCE
        }
    }

}