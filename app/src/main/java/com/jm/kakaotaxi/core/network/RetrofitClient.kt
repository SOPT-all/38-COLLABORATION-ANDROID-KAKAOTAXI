package com.jm.kakaotaxi.core.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jm.kakaotaxi.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitClient {
    private const val BASE_URL = BuildConfig.BASE_URL

    private val json = Json { ignoreUnknownKeys = true }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    private fun okHttpClient(interceptor: TokenInterceptor): OkHttpClient
            = OkHttpClient.Builder().run {
        addInterceptor(interceptor)
        addInterceptor(loggingInterceptor)
        build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient(TokenInterceptor()))
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
}
