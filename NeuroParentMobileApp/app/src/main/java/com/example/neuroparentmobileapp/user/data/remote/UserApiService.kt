package

import user.data.remote.dto.UserDto
import retrofit2.http.*

interface UserApiService {

    @GET("users")
    suspend fun getAllUsers(): List<UserDto> // admin only

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: String): UserDto

    @POST("users")
    suspend fun createUser(@Body user: UserDto): UserDto

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: String, @Body user: UserDto): UserDto

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: String)
}
