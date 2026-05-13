package com.jm.kakaotaxi.presentation.search.type

import androidx.annotation.DrawableRes
import com.jm.kakaotaxi.R

enum class SearchHistoryType(
    @DrawableRes val icon: Int,
) {
    MAP(
        icon = R.drawable.ic_location,
    ),
    DIRECT(
        icon = R.drawable.ic_search,
    );
}
