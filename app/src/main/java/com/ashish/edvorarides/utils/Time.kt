package com.ashish.edvorarides.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getCurrentDate(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    return current.format(formatter)
}