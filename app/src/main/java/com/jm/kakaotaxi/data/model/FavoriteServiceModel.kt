package com.jm.kakaotaxi.data.model

import com.jm.kakaotaxi.R

data class FavoriteServiceModel(
    val title: String,
    val subtitle: String,
    val starIcon: Int = R.drawable.ic_home_star_gray,
    val carImage: Int
)