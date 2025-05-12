package com.example.neuroparentmobileapp.auth.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class TokenManager(private val context: Context) {
    companion object {
        private val Context.dataStore by preferencesDataStore("auth_prefs")
        val TOKEN_KEY = stringPreferencesKey("jwt_token")
    }

    val token: Flow<String?> = context.dataStore.data.map { it[TOKEN_KEY] }

    suspend fun saveToken(token: String) {
        context.dataStore.edit { it[TOKEN_KEY] = token }
    }

    suspend fun clearToken() {
        context.dataStore.edit { it.remove(TOKEN_KEY) }
    }

    fun forgetToken(tokenManager: TokenManager) {
        runBlocking {
            tokenManager.clearToken()
            println("Token has been forgotten.")
        }
    }
}