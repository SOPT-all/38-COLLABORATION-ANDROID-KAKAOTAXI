package com.jm.kakaotaxi.presentation.arrival

interface ArrivalContract {
    data class State(
        val taxiType: String = "" ,
        val carNumber : String = "",
        val carType : String = "",
        val carColor : String = "",
        val driverName : String = ""
    )
}