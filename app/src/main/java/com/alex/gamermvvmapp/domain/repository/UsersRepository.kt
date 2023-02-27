package com.alex.gamermvvmapp.domain.repository

import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.model.User
import kotlinx.coroutines.flow.Flow


interface UsersRepository {

    //Retorna boolean para saber si se creo
    suspend fun create(user: User): Response<Boolean>
    suspend fun update(user: User): Response<Boolean>
    fun getUserById(id:String): Flow<User>
}