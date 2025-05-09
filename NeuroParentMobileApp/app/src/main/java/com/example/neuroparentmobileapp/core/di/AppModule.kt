package com.example.neuroparentmobileapp.core.di

import android.content.Context
import com.example.neuroparentmobileapp.auth.data.local.AuthPreferences
import com.example.neuroparentmobileapp.auth.data.remote.AuthApiService
import com.example.neuroparentmobileapp.auth.data.repository.AuthRepositoryImpl
import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository
import com.example.neuroparentmobileapp.auth.domain.usecase.LoginUseCase
import com.example.neuroparentmobileapp.auth.domain.usecase.RegisterUseCase
import com.example.neuroparentmobileapp.auth.domain.usecase.ValidateCredentialsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    companion object {
        @Provides
        @Singleton
        fun provideAuthPreferences(@ApplicationContext context: Context): AuthPreferences {
            return AuthPreferences(context)
        }

        @Provides
        @Singleton
        fun provideLoginUseCase(repository: AuthRepository): LoginUseCase {
            return LoginUseCase(repository)
        }

        @Provides
        @Singleton
        fun provideRegisterUseCase(repository: AuthRepository): RegisterUseCase {
            return RegisterUseCase(repository)
        }

        @Provides
        @Singleton
        fun provideValidateCredentialsUseCase(): ValidateCredentialsUseCase {
            return ValidateCredentialsUseCase()
        }
    }
}