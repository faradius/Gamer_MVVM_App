package com.alex.gamermvvmapp.di

import com.alex.gamermvvmapp.core.Constants.USERS
import com.alex.gamermvvmapp.data.repository.AuthRepositoryImpl
import com.alex.gamermvvmapp.data.repository.UsersRepositoryImpl
import com.alex.gamermvvmapp.domain.repository.AuthRepository
import com.alex.gamermvvmapp.domain.repository.UsersRepository
import com.alex.gamermvvmapp.domain.use_cases.auth.*
import com.alex.gamermvvmapp.domain.use_cases.users.Create
import com.alex.gamermvvmapp.domain.use_cases.users.GetUserById
import com.alex.gamermvvmapp.domain.use_cases.users.UsersUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signUp = SignUp(repository)
    )

    @Provides
    fun provideUsersUseCases(repository: UsersRepository) = UsersUseCases(
        create = Create(repository),
        getUserById = GetUserById(repository)
    )
}