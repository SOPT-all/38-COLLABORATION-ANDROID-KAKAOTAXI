package com.jm.kakaotaxi.data.model.home

import androidx.annotation.DrawableRes

data class FavoriteServiceModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val isStarClicked: Boolean = false,
    @DrawableRes val carImage: Int
)