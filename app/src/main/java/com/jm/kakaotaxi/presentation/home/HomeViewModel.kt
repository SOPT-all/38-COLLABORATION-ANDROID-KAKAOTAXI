package com.jm.kakaotaxi.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.home.FavoriteServiceModel
import com.jm.kakaotaxi.data.repository.api.PlaceRepository
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(
    private val placeRepository: PlaceRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchQuickPlaces()
        getFavoritePlaces()
    }

    fun fetchQuickPlaces() = viewModelScope.launch {
        placeRepository.getQuickPlaces()
            .onSuccess { quickPlaces ->
                _uiState.update {
                    it.copy(
                        quickPlaces = quickPlaces.quickPlaceModel.toImmutableList()
                    )
                }
            }
            .onFailure {
                Timber.d("즐겨찾는 장소 목록을 불러올 수 없습니다.")
            }
    }

    private fun getFavoritePlaces() {
        _uiState.update {
            it.copy(
                favoritePlaces = persistentListOf(
                    FavoriteServiceModel(
                        id = 1,
                        title = "택시",
                        subtitle = "바로 이동해볼까요?",
                        carImage = R.drawable.img_home_taxi
                    ),
                    FavoriteServiceModel(
                        id = 2,
                        title = "택시 예약",
                        subtitle = "미리 예약해볼까요?",
                        carImage = R.drawable.img_home_taxi_reservation
                    ),
                    FavoriteServiceModel(
                        id = 3,
                        title = "기차/버스",
                        subtitle = "교통편을 찾아볼까요?",
                        carImage = R.drawable.img_home_train_bus
                    ),
                    FavoriteServiceModel(
                        id = 4,
                        title = "렌터카",
                        subtitle = "차를 빌려볼까요?",
                        carImage = R.drawable.img_home_rental_car
                    )
                )
            )
        }
    }

    fun onStarClick(id: Int) {
        val updateList = _uiState.value.favoritePlaces.map { service ->
            if (service.id == id)
                service.copy(isStarClicked = !service.isStarClicked)
            else service
        }.toImmutableList()
        _uiState.update {
            it.copy(favoritePlaces = updateList)
        }
    }
}
