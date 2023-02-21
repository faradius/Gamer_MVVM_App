package com.alex.gamermvvmapp.di

import com.alex.gamermvvmapp.data.repository.AuthRepositoryImpl
import com.alex.gamermvvmapp.domain.repository.AuthRepository
import com.alex.gamermvvmapp.domain.use_cases.auth.AuthUseCases
import com.alex.gamermvvmapp.domain.use_cases.auth.GetCurrentUser
import com.alex.gamermvvmapp.domain.use_cases.auth.Login
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository)
    )
}