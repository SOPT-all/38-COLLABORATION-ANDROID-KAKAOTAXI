package com.jm.kakaotaxi.data.model

import androidx.annotation.DrawableRes
import com.jm.kakaotaxi.R

data class FavoriteServiceModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    @DrawableRes val starIcon: Int = R.drawable.ic_home_star_gray,
    @DrawableRes val carImage: Int
)