package com.xplora.challenge.DataRepository

import com.xplora.challenge.base.BaseRepository
import com.xplora.challenge.helpers.MyPreference
import com.xplora.challenge.model.LoginResponse
import com.xplora.challenge.model.ModuleResponse
import com.xplora.challenge.network.Resource
import com.xplora.challenge.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class XploraRepository: BaseRepository(){

    suspend fun getLogin(email: String?, password: String?): Resource<LoginResponse?>{

        return withContext(Dispatchers.IO) {
            return@withContext networkCall(
                call = {
                    RetrofitBuilder.apiService.login(email, password)
                })
        }
    }

    suspend fun getModules(): Resource<ModuleResponse?>{

        return withContext(Dispatchers.IO) {
            return@withContext networkCall(
                call = {
                    RetrofitBuilder.apiService.modules(MyPreference.getAuthToken())
                })
        }
    }
}