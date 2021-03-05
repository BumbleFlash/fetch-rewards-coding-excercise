package com.example.fetchrewardscodingexcercise.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The service builder class to initialize the base url and Http client to work with retrofit.
 */
object RetrofitServiceBuilder {

    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private val okHttpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}