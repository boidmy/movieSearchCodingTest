package com.example.movie.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnection {

    private val retrofit: Retrofit

    private val baseUrl = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp/"

    val retrofitService: ApiService
        get() = retrofit.create(ApiService::class.java)

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