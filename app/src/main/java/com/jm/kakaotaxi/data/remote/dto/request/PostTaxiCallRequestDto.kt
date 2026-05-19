package com.jm.kakaotaxi.data.remote.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostTaxiCallRequestDto(
    @SerialName("placeId")
    val placeId: Int,
)