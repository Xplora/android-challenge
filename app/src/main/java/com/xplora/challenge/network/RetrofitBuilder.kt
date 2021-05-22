package com.xplora.challenge.network

import com.xplora.challenge.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    const val BASE_URL: String = "http://demo.goxplora.com/"

    private const val BASE_URL_API: String = "http://demo.goxplora.com/api/"

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
    }

    val apiService: ApiService by lazy {

        retrofitBuilder.build().create(ApiService::class.java)
    }

    private val okHttpClientBuilder: OkHttpClient.Builder by lazy {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(logging)
        }
        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.addInterceptor(HttpHandleIntercept())
    }

    private val okHttpClient: OkHttpClient by lazy {

        okHttpClientBuilder.build()
    }

}