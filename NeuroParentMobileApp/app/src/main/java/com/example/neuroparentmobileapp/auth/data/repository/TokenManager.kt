package com.example.neuroparentmobileapp.auth.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenManager(private val context: Context) {
    companion object {
        private val Context.dataStore by preferencesDataStore("auth_prefs")
        val TOKEN_KEY = stringPreferencesKey("jwt_token")
        private val USER_ID_KEY = stringPreferencesKey("user_id")
        private val USER_ROLE_KEY = stringPreferencesKey("user_role")
    }

    val token: Flow<String?> = context.dataStore.data.map { it[TOKEN_KEY] }
    val userId: Flow<String?> = context.dataStore.data.map { it[USER_ID_KEY] }
    val userRole: Flow<String?> = context.dataStore.data.map { it[USER_ROLE_KEY] }

    suspend fun saveToken(token: String) {
        context.dataStore.edit { it[TOKEN_KEY] = token }
    }



    suspend fun saveTokenAndUserDetails(token: String, userId: String, role: String) {
        context.dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
            preferences[USER_ID_KEY] = userId
            preferences[USER_ROLE_KEY] = role
        }
    }

    suspend fun clearToken() {
        context.dataStore.edit { it.remove(TOKEN_KEY) }
    }
} 