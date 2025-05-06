package com.example.neuroparentmobileapp.auth.domain.model

data class AuthUser(
    val id: Int? = null,          
    val name: String,            
    val email: String,           
    val role: String      
)

