package com.xplora.challenge.request

import com.google.gson.annotations.SerializedName

class LoginRequest {

    @field:SerializedName("email")
    var email: String? = "demo@goxplora.com"

    @field:SerializedName("password")
    var password: String? = "demo1234"
}