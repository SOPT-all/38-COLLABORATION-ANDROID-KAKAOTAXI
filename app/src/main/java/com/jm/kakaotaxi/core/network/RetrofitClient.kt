package com.jm.kakaotaxi.core.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jm.kakaotaxi.BuildConfig
import com.jm.kakaotaxi.data.remote.service.PlaceService
import com.jm.kakaotaxi.data.remote.service.TaxiCallService
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

    private fun okHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient())
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val taxiCallService: TaxiCallService = retrofit.create(TaxiCallService::class.java)
    val placeService: PlaceService = retrofit.create(PlaceService::class.java)
}
