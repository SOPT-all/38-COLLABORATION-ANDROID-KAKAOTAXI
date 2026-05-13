package com.jm.kakaotaxi.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class QuickPlaceModel(
    val title: String,
    @DrawableRes val icon: Int,
    val color: Color
)