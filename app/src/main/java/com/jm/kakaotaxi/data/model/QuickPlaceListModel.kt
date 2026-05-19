package com.jm.kakaotaxi.data.model

import androidx.annotation.DrawableRes


data class QuickPlaceListModel(
    val quickPlaceModel: List<QuickPlaceModel>
)

data class QuickPlaceModel(
    val id: Int,
    val title: String,
    @DrawableRes val icon: Int
)