package com.jm.kakaotaxi.data.model.search

import com.jm.kakaotaxi.presentation.search.type.SearchHistoryType

data class SearchHistoryModel(
    val type: SearchHistoryType,
    val place: String,
    val address: String
)
