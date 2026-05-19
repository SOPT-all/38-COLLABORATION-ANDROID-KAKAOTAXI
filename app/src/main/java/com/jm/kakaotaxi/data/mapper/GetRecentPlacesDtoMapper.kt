package com.jm.kakaotaxi.data.mapper

import com.jm.kakaotaxi.core.util.DateFormatter
import com.jm.kakaotaxi.data.model.search.SearchRecentModel
import com.jm.kakaotaxi.data.remote.dto.response.GetRecentPlacesResponseDto

fun GetRecentPlacesResponseDto.toSearchRecentModel() = SearchRecentModel(
    id = this.id,
    place = this.name,
    time = DateFormatter.formatDate(this.lastVisitedAt),
    location = this.address.split(" ")[1],
)
