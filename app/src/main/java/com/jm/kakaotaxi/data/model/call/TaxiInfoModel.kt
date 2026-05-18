package com.jm.kakaotaxi.data.model.call

import androidx.annotation.DrawableRes

data class TaxiInfoModel(
    val id: Int,
    @DrawableRes val taxiImage: Int,
    val taxiType: String,
    val taxiDescription: String,
    val taxiPrice: String,
)