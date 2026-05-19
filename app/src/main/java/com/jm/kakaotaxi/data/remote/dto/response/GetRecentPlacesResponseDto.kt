package com.jm.kakaotaxi.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetRecentPlacesResponseDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("last_visited_at")
    val lastVisitedAt: String,
    @SerialName("address")
    val address: String,
)
