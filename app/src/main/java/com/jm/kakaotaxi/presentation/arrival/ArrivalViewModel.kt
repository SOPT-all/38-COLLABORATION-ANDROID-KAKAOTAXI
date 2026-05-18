package com.jm.kakaotaxi.presentation.arrival

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ArrivalViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ArrivalContract.State())
    val uiState = _uiState.asStateFlow()

    init{
        getTaxiInfo()
    }
    private fun getTaxiInfo() {
        _uiState.update {
            // api 연동
            it.copy(
                taxiType = "안심택시",
                carNumber = "서울 38 아 2864",
                carType = "현대 쏘나타",
                carColor = "화이트",
                driverName = "김민수"
            )
        }
    }
}