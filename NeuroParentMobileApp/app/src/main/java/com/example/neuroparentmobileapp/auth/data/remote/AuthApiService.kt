package auth.data.remote

import auth.data.remote.dto.LoginRequest
import auth.data.remote.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("auth/register")
    suspend fun register(@Body request: LoginRequest): LoginResponse
}
