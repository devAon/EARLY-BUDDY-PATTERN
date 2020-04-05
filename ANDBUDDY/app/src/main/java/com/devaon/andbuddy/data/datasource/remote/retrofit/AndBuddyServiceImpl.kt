package com.devaon.andbuddy.data.datasource.remote.retrofit

import com.devaon.andbuddy.intercepter.CookiesIntercepter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AndBuddyServiceImpl {
    private const val BASE_URL = "http://15.164.70.24:3456/"

    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(CookiesIntercepter())
            .addNetworkInterceptor(CookiesIntercepter()).build()

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).client(
            okHttpClient
        )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service: AndBuddyService = retrofit.create(
        AndBuddyService::class.java)
}