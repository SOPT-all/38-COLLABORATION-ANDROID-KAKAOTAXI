package com.jm.kakaotaxi.data.model

import androidx.annotation.DrawableRes

data class FavoriteServiceModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val isStarClicked: Boolean,
    @DrawableRes val carImage: Int
)