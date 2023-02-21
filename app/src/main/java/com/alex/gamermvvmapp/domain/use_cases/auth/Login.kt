package com.alex.gamermvvmapp.domain.use_cases.auth

import com.alex.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository){
    //Esta es una función que se ejecutará automaticamente y con esto ya no es necesario usar el init
    suspend operator fun invoke(email: String, pasword: String) = repository.login(email, pasword)
}