package com.alex.gamermvvmapp.data.repository

import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.model.User
import com.alex.gamermvvmapp.domain.repository.UsersRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val usersRef: CollectionReference): UsersRepository {
    override suspend fun create(user: User): Response<Boolean> {
        return try {
            user.password = ""
            usersRef.document(user.id).set(user).await()
            Response.Success(true)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}