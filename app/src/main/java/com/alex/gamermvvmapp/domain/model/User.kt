package com.alex.gamermvvmapp.domain.model

import com.google.gson.Gson

data class User (
    var id: String = "",
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var image: String = ""
){
    //Se transforma el objeto user a un json
    fun toJson(): String = Gson().toJson(this)

    companion object{
        fun fromJson(data: String):User = Gson().fromJson(data, User::class.java)
    }
}

