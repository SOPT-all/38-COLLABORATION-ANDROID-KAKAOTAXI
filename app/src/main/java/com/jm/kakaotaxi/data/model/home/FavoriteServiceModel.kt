package com.jm.kakaotaxi.data.model.home

import androidx.annotation.DrawableRes

data class FavoriteServiceModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    @DrawableRes val carImage: Int
)