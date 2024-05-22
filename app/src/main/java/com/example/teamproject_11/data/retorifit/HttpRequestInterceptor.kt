package com.example.teamproject_11.data.retorifit

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

internal class HttpRequestInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    this.addHeader("Api Key", "AIzaSyBFuwRyskATZg2Q7wdtF3QBOePjpKpfboo")
                }
                .build()
        )
    }
}