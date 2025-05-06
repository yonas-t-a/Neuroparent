package com.example.neuroparentmobileapp.core.di


import UserApiService
import auth.data.remote.AuthApiService
import com.example.neuroparentmobileapp.admin.data.remote.AdminArticleApiService
import com.example.neuroparentmobileapp.admin.data.remote.AdminEventApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import user.data.remote.*

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "http://10.0.2.2:3500/api/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    // ✅ API Interfaces
    @Provides @Singleton fun provideAuthApi(retrofit: Retrofit): AuthApiService =
        retrofit.create(AuthApiService::class.java)

    @Provides @Singleton fun provideArticleApi(retrofit: Retrofit): ArticleApiService =
        retrofit.create(ArticleApiService::class.java)

    @Provides @Singleton fun provideAdminArticleApi(retrofit: Retrofit): AdminArticleApiService =
        retrofit.create(AdminArticleApiService::class.java)

    @Provides @Singleton fun provideEventApi(retrofit: Retrofit): EventApiService =
        retrofit.create(EventApiService::class.java)

    @Provides @Singleton fun provideAdminEventApi(retrofit: Retrofit): AdminEventApiService =
        retrofit.create(AdminEventApiService::class.java)

    @Provides @Singleton fun provideUserApi(retrofit: Retrofit): UserApiService =
        retrofit.create(UserApiService::class.java)
//    @Provides @Singleton fun provideUserEventApi(retrofit: Retrofit): UserEventApiService =
//        retrofit.create(UserEventApiService::class.java)
}
