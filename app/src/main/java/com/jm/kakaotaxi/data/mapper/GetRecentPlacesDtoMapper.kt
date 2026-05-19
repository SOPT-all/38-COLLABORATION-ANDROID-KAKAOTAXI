package com.jm.kakaotaxi.data.mapper

import com.jm.kakaotaxi.data.model.search.SearchRecentModel
import com.jm.kakaotaxi.data.remote.dto.response.GetRecentPlacesDto

fun GetRecentPlacesDto.toSearchRecentModel() = SearchRecentModel(
    id = this.id,
    place = this.name,
    time = this.lastVisitedAt,
    location = this.address,
)
