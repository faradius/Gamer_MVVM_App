package com.alex.gamermvvmapp.domain.use_cases.users

data class UsersUseCases(
    val create: Create,
    val getUserById: GetUserById,
    val update: Update
)
