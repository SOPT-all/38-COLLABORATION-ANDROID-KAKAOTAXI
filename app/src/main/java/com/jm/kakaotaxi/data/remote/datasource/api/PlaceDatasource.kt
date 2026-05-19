package com.jm.kakaotaxi.data.remote.datasource.api

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.response.GetRecentPlacesResponseDto

interface PlaceDataSource {
    suspend fun getQuickPlaces(): BaseResponse<List<String>>
    suspend fun getRecentPlaces(): BaseResponse<List<GetRecentPlacesResponseDto>>
}

