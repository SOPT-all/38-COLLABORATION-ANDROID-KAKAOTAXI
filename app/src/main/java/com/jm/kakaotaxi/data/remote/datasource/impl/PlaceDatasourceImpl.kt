package com.jm.kakaotaxi.data.remote.datasource.impl

import com.jm.kakaotaxi.data.remote.datasource.api.PlaceDataSource
import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.response.GetRecentPlacesResponseDto
import com.jm.kakaotaxi.data.remote.service.PlaceService

class PlaceDataSourceImpl (
    private val placeService: PlaceService,
) : PlaceDataSource {

    override suspend fun getRecentPlaces(): BaseResponse<List<GetRecentPlacesResponseDto>> {
        return placeService.getRecentPlaces()
    }

}
