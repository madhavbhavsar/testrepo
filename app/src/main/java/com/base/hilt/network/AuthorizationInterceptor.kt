package com.base.hilt.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", HttpCommonMethod.getAuthToken())
            .build()

        return chain.proceed(request)
    }
}