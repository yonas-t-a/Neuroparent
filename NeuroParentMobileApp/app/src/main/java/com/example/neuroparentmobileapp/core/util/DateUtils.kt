package com.example.neuroparentmobileapp.core.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {
    fun formatDate(date: Date, pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
        val formatter = SimpleDateFormat(pattern, Locale.getDefault())
        return formatter.format(date)
    }
    fun parseDate(dateString: String, pattern: String = "yyyy-MM-dd HH:mm:ss"): Date? {
        return try {
            val formatter = SimpleDateFormat(pattern, Locale.getDefault())
            formatter.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }
    fun getCurrentDateTime(pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
        return formatDate(Date(), pattern)
    }
    
}
