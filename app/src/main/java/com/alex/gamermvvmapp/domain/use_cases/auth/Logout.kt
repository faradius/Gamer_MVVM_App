package com.alex.gamermvvmapp.domain.use_cases.auth

import com.alex.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val respository: AuthRepository) {
    operator fun invoke() = respository.logout()
}