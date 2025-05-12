package com.example.neuroparentmobileapp.core.util

object ValidationUtils {
    
    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return email.matches(emailRegex)
    }
    
    fun isValidPassword(password: String): Boolean {
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$".toRegex()
        return password.matches(passwordRegex)
    }
    
    fun isNotEmpty(input: String): Boolean {
        return input.isNotBlank()
    }
    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phoneRegex = "^\\+?[0-9]{10,15}$".toRegex()
        return phoneNumber.matches(phoneRegex)
    }
}
