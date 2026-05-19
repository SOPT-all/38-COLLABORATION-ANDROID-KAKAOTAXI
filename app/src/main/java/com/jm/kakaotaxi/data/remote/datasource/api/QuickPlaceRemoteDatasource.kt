package com.jm.kakaotaxi.data.remote.datasource.api

import com.jm.kakaotaxi.data.remote.dto.BaseResponse


interface QuickPlaceRemoteDatasource {
    suspend fun getQuickPlace(): BaseResponse<List<String>>
}