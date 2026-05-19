package com.jm.kakaotaxi.data.repository.api

interface TaxiCallRepository {
    suspend fun postTaxiCall(placeId: Int): Result<Unit>
}