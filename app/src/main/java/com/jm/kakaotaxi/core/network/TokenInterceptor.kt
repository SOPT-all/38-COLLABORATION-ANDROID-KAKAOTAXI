package com.jm.kakaotaxi.core.network

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val newRequest = request().newBuilder()
            .addHeader(HEADER_USER_ID, "1")
            .build()
        proceed(newRequest)
    }

    companion object {
        private const val HEADER_USER_ID = "X-User-Id"
    }
}
