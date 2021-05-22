package com.xplora.challenge.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: LoginData? = null,
)

data class LoginData(

	@field:SerializedName("user")
	val user: User? = null
)

data class User(

	@field:SerializedName("api_token")
	val apiToken: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
