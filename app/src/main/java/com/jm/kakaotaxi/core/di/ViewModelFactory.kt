package com.jm.kakaotaxi.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jm.kakaotaxi.core.network.RetrofitClient
import com.jm.kakaotaxi.data.remote.datasource.impl.PlaceDataSourceImpl
import com.jm.kakaotaxi.data.repository.impl.PlaceRepositoryImpl
import com.jm.kakaotaxi.presentation.arrival.ArrivalViewModel
import com.jm.kakaotaxi.presentation.call.CallViewModel
import com.jm.kakaotaxi.presentation.home.HomeViewModel
import com.jm.kakaotaxi.presentation.search.SearchViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel() as T
        } else if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(PlaceRepositoryImpl(PlaceDataSourceImpl(RetrofitClient.placeService))) as T
        } else if (modelClass.isAssignableFrom(CallViewModel::class.java)) {
            return CallViewModel() as T
        } else if (modelClass.isAssignableFrom(ArrivalViewModel::class.java)) {
            return ArrivalViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
