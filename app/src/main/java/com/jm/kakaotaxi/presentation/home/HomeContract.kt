package com.jm.kakaotaxi.presentation.home

import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import com.jm.kakaotaxi.data.model.home.FavoriteServiceModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface HomeContract {
    data class State(
        val quickPlaces: ImmutableList<QuickPlaceModel> = persistentListOf(),
        val favoritePlaces: ImmutableList<FavoriteServiceModel> = persistentListOf()
    )
}