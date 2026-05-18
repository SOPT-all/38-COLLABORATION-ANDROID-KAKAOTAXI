package com.jm.kakaotaxi.presentation.call

import androidx.lifecycle.ViewModel
import com.jm.kakaotaxi.data.model.call.TaxiInfoModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CallViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CallContract.State())
    val uiState = _uiState.asStateFlow()

    fun onTaxiSelected(taxi: TaxiInfoModel) {
        _uiState.update { it.copy(selectedTaxi = taxi) }
    }

    fun onNextStep() {
        _uiState.update { it.copy(bottomSheetStep = it.bottomSheetStep + 1) }
    }

    fun onPreviousStep() {
        _uiState.update { it.copy(bottomSheetStep = it.bottomSheetStep - 1) }
    }
}