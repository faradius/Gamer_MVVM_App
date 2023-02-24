package com.alex.gamermvvmapp.domain.repository

import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.model.User

interface UsersRepository {

    //Retorna boolean para saber si se creo
    suspend fun create(user: User): Response<Boolean>
}