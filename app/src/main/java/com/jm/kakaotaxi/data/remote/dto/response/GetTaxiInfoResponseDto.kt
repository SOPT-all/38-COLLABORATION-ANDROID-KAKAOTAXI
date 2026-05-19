package com.jm.kakaotaxi.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CallInfo(
    @SerialName("taxi_id")
    val taxi_id: Int,
    @SerialName("type")
    val type: String,
    @SerialName("model_name")
    val model_name: String,
    @SerialName("model_color")
    val model_color: String,
    @SerialName("plate_number")
    val plate_number: String,
    @SerialName("driver_name")
    val driver_name: String,
)