package com.jm.kakaotaxi.core.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferencesUtil(
    context: Context,
) {

    private val pref: SharedPreferences =
        context.getSharedPreferences(PrefKeys.PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun setTaxiId(
        taxiId: Int,
    ) = pref.edit {
        putInt(PrefKeys.PREFERENCE_TAXI_ID, taxiId)
    }

    fun getTaxiId(): Int {
        return pref.getInt(PrefKeys.PREFERENCE_TAXI_ID, -1)
    }

    object PrefKeys {
        const val PREFERENCE_NAME = "kakao_taxi_pref"
        const val PREFERENCE_TAXI_ID = "taxi_id"
    }
}

