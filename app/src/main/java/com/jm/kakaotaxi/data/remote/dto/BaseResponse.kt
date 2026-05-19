package com.jm.kakaotaxi.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("status")
    val status: Int,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T? = null,
)

@Serializable
data class T(
    @SerialName("taxi")
    val taxi: List<CallInfo>
){}
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
){}
