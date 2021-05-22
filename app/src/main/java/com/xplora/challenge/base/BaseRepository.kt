package com.xplora.challenge.base

import android.accounts.NetworkErrorException
import com.google.gson.Gson
import com.xplora.challenge.network.ErrorWrapper
import com.xplora.challenge.network.HttpCommonMethod
import com.xplora.challenge.network.Resource
import okhttp3.internal.http2.ConnectionShutdownException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class BaseRepository {

    suspend fun <T : Any> networkCall(call: suspend () -> Response<T>?): Resource<T?> {

        try {
            val response = call()
            return when {
                response?.code() == 200 -> Resource.success(response.body())
                response?.code() == 201 -> Resource.success(response.body())
                response?.code() == 400 -> {
                    val body = response.errorBody()
                    val bodyString = body?.string()
                    val responseWrapper = Gson().fromJson(bodyString, ErrorWrapper::class.java)
                    val message =  HttpCommonMethod.getErrorMessage(responseWrapper.errors)
                    Resource.error(message)
                }
                else -> Resource.error(response?.message())
            }
        } catch (e: Exception) {
            return if (e is ConnectionShutdownException || e is UnknownHostException) {
                e.printStackTrace()
                Resource.error("Your internet connection is either slow or shut down")
            } else if (e is SocketTimeoutException || e is IOException || e is NetworkErrorException) {
                e.printStackTrace()
                Resource.error("Please check your internet connection")
            } else {
                e.printStackTrace()
                Resource.error("Network call has failed for a some reason")
            }
        }
    }
}