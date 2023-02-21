package com.alex.gamermvvmapp.domain.repository

import com.alex.gamermvvmapp.domain.model.Response
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>
}