package com.jm.kakaotaxi.data.mapper

import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.QuickPlaceListModel
import com.jm.kakaotaxi.data.model.QuickPlaceModel

private val icons = listOf(
    R.drawable.ic_home,
    R.drawable.ic_hospital,
    R.drawable.ic_senior_home
)

fun List<String>.toQuickPlaceListModel() = QuickPlaceListModel(
    quickPlaceModel = mapIndexed { index, title ->
        QuickPlaceModel(
            id = index,
            title = title,
            icon = icons.getOrElse(index) { R.drawable.ic_senior_home }
        )
    }
)