package com.jm.kakaotaxi.core.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale


object DateFormatter {
    fun formatDate(dateString: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd'T'HHmmss", Locale.KOREAN)

        val receivedDate = LocalDateTime.parse(dateString, formatter)
        val now = LocalDateTime.now()

        val days = ChronoUnit.DAYS.between(receivedDate, now)
        val months = ChronoUnit.MONTHS.between(receivedDate, now)
        val years = ChronoUnit.YEARS.between(receivedDate, now)

        val timeText = if (receivedDate.hour < 12) "오전" else "오후"

        return when {
            days == 0L -> "오늘 $timeText"
            days == 1L -> "어제 $timeText"
            days < 30 -> "${days}일 전 $timeText"
            months < 12 -> "${months}개월 전 $timeText"
            else -> "${years}년 전 $timeText"
        }
    }
}
