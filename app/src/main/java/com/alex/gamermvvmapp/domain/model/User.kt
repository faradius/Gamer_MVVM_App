package com.alex.gamermvvmapp.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    var id: String = "",
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var image: String = ""
) {
    //Se transforma el objeto user a un json
    fun toJson(): String = Gson().toJson(
        User(
        id,
            username,
            email,
            password,
            //Hacemos que compose navigation lo reconozca como una URL y no parte de una ruta por que si no sale error
            if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else ""
        )
    )

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}

