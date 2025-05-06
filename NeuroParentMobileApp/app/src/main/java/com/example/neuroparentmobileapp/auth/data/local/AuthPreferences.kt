package com.example.neuroparentmobileapp.auth.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.authDataStore by preferencesDataStore("auth_prefs")

class AuthPreferences(private val context: Context) {

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("jwt_token")
    }

    val token: Flow<String?> = context.authDataStore.data
        .map { it[TOKEN_KEY] }

    suspend fun saveToken(token: String) {
        context.authDataStore.edit { it[TOKEN_KEY] = token }
    }

    suspend fun clearToken() {
        context.authDataStore.edit { it.remove(TOKEN_KEY) }
    }
}