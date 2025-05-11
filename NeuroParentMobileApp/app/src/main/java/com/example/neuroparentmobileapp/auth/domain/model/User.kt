package com.example.neuroparentmobileapp.auth.domain.model

data class User(
    val name: String,
    val email: String,
    val role: String = "user"
) 

