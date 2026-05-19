package com.jm.kakaotaxi.data.remote.datasource.impl

import com.jm.kakaotaxi.data.remote.datasource.api.QuickPlaceRemoteDatasource
import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.service.PlaceService

class QuickPlaceRemoteDatasourceImpl (
    private val placeService: PlaceService,
    ) : QuickPlaceRemoteDatasource {

    override suspend fun getQuickPlace(): BaseResponse<List<String>> {
        return placeService.getQuickPlace()
    }

}