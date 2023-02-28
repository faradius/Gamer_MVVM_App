package com.alex.gamermvvmapp.domain.repository

import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.model.User
import kotlinx.coroutines.flow.Flow
import java.io.File


interface UsersRepository {

    //Retorna boolean para saber si se creo
    suspend fun create(user: User): Response<Boolean>
    suspend fun update(user: User): Response<Boolean>
    //Nos va a devolver una url
    suspend fun saveImage(file:File): Response<String>
    fun getUserById(id:String): Flow<User>
}