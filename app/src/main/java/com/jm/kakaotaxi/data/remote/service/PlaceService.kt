package com.jm.kakaotaxi.data.remote.service

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import retrofit2.http.GET

interface PlaceService {
    @GET("/v1/places/favorite")
    suspend fun getQuickPlaces(): BaseResponse<List<String>>
}
