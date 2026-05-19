package com.jm.kakaotaxi.data.remote.datasource.api

import com.jm.kakaotaxi.data.remote.dto.BaseResponse


interface PlaceDataSource {
    suspend fun getQuickPlaces(): BaseResponse<List<String>>
}