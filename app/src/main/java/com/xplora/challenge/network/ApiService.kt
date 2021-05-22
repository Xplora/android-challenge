package com.xplora.challenge.network

import com.xplora.challenge.model.LoginResponse
import com.xplora.challenge.model.ModuleResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    @FormUrlEncoded
    suspend fun login(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Response<LoginResponse>

    @POST("modules")
    @FormUrlEncoded
    suspend fun modules(
        @Field("api_token") email: String?,
    ): Response<ModuleResponse>
}