package com.jm.kakaotaxi.presentation.call

import com.jm.kakaotaxi.data.model.call.TaxiInfoModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface CallContract {
    data class State(
        val taxiInfo: ImmutableList<TaxiInfoModel> = persistentListOf(),
        val selectedTaxi: TaxiInfoModel
    )
}