package com.devaon.andbuddy.intercepter
import okhttp3.Interceptor
import okhttp3.Response

class CookiesIntercepter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder().header("Content-Type", "application/json")
                .build()
        return chain.proceed(request)
    }
}