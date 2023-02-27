package com.alex.gamermvvmapp.domain.use_cases.users

import com.alex.gamermvvmapp.domain.model.User
import com.alex.gamermvvmapp.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(private val repository: UsersRepository) {
    suspend operator fun invoke(user:User) = repository.update(user)
}