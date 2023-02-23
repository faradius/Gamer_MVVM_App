package com.alex.gamermvvmapp.domain.use_cases.auth

import com.alex.gamermvvmapp.domain.model.User
import com.alex.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class SignUp @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.signUp(user)
}