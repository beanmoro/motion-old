package com.example.motionapp.data.models

import android.graphics.Bitmap

data class User(
    var rut : String = "",
    var nombre : String = "",
    var apellido : String = "",
    var email : String = "",
    var password : String = "",
    var avatar : String = ""
)