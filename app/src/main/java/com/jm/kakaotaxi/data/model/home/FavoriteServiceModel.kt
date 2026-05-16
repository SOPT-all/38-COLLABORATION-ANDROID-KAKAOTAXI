package com.jm.kakaotaxi.data.model.home

import androidx.annotation.DrawableRes

data class FavoriteServiceModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    var isStarClicked: Boolean,
    @DrawableRes val carImage: Int
)