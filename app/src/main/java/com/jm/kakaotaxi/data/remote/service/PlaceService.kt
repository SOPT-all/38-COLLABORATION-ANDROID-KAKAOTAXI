package com.jm.kakaotaxi.data.remote.service

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.response.GetRecentPlacesResponseDto
import retrofit2.http.GET

interface PlaceService {

    @GET("/v1/places/favorite")
    suspend fun getQuickPlaces(): BaseResponse<List<String>>

    @GET("/v1/places/recent")
    suspend fun getRecentPlaces(): BaseResponse<List<GetRecentPlacesResponseDto>>

}
