package com.jm.kakaotaxi.data.model.call

import androidx.annotation.DrawableRes

data class TaxiInfoModel(
    val id: String,
    @DrawableRes val taxiImage: Int,
    val taxiType: String,
    val taxiDescription: String,
    val taxiPrice: String,
)