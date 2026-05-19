package com.jm.kakaotaxi.data.remote.datasource.api

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.response.GetRecentPlacesDto

interface PlaceDataSource {
    suspend fun getRecentPlaces(): BaseResponse<List<GetRecentPlacesDto>>
}
