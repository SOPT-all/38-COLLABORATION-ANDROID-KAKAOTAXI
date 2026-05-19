package com.jm.kakaotaxi.data.remote.datasource.api

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import retrofit2.http.GET

interface QuickPlaceApi {
    @GET("/v1/places/favorite")
    suspend fun getQuickPlace(): BaseResponse<List<String>>
}