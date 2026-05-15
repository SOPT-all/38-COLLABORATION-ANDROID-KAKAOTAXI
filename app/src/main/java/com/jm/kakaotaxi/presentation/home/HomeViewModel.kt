package com.jm.kakaotaxi.presentation.home

import androidx.lifecycle.ViewModel
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.FavoriteServiceModel
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

class HomeViewModel : ViewModel() {
    val fakeHomeData = persistentListOf(
        QuickPlaceModel(1, "집", R.drawable.ic_home),
        QuickPlaceModel(2, "한사랑병원", R.drawable.ic_hospital),
        QuickPlaceModel(3, "노인정", R.drawable.ic_senior_home)
    )

    fun getHomeData() = fakeHomeData


    val favoriteServices: PersistentList<FavoriteServiceModel> = persistentListOf(
        FavoriteServiceModel(
            id = 1,
            title = "택시",
            subtitle = "바로 이동해볼까요?",
            isStarClicked = true,
            carImage = R.drawable.img_home_taxi
        ),
        FavoriteServiceModel(
            id = 2,
            title = "택시 예약",
            subtitle = "미리 예약해볼까요?",
            isStarClicked = false,
            carImage = R.drawable.img_home_taxi_reservation
        ),
        FavoriteServiceModel(
            id = 3,
            title = "기차/버스",
            subtitle = "교통편을 찾아볼까요?",
            isStarClicked = false,
            carImage = R.drawable.img_home_train_bus
        ),
        FavoriteServiceModel(
            id = 4,
            title = "렌터카",
            subtitle = "차를 빌려볼까요?",
            isStarClicked = false,
            carImage = R.drawable.img_home_rental_car
        )
    )


    fun onSearchBarClick(){
        // 흠 검색바 누르면 어케되는거지
    }

    fun onStarClick(model: FavoriteServiceModel){

    }
}
