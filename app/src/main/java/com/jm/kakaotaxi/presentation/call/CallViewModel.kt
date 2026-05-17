package com.jm.kakaotaxi.presentation.call

import androidx.lifecycle.ViewModel
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.call.TaxiInfoModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CallViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CallContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        getTaxiInfo()
    }

    private fun getTaxiInfo() {
        val taxiInfoList = persistentListOf(
            TaxiInfoModel(
                id = 1,
                taxiImage = R.drawable.img_calltaxi_safetaxi,
                taxiType = "안심 택시",
                taxiDescription = "친절한 기사님\n바로 배차 보장",
                taxiPrice = "7,800",
            ),
            TaxiInfoModel(
                id = 2,
                taxiImage = R.drawable.img_calltaxi_gentaxi,
                taxiType = "일반 택시",
                taxiDescription = "가장 빠르게\n주변 택시 연결",
                taxiPrice = "4,800",
            ),
            TaxiInfoModel(
                id = 3,
                taxiImage = R.drawable.img_calltaxi_greattaxi,
                taxiType = "모범 택시",
                taxiDescription = "고급 차량\n베테랑 기사님",
                taxiPrice = "10,000",
            ),
            TaxiInfoModel(
                id = 4,
                taxiImage = R.drawable.img_calltaxi_bigtaxi,
                taxiType = "대형 택시",
                taxiDescription = "넓은 좌석\n짐이 많을 때",
                taxiPrice = "13,000",
            ),
        )

        _uiState.update {
            it.copy(
                taxiInfo = taxiInfoList,
                selectedTaxi = taxiInfoList.first()
            )
        }
    }

    fun onTaxiSelected(taxi: TaxiInfoModel) {
        _uiState.update { it.copy(selectedTaxi = taxi) }
    }
}