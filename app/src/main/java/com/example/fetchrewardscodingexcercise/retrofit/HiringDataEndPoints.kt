package com.example.fetchrewardscodingexcercise.retrofit

import com.example.fetchrewardscodingexcercise.model.HiringData
import retrofit2.Call
import retrofit2.http.GET

interface HiringDataEndPoints {

    @GET("hiring.json")
    fun getHiringData(): Call<List<HiringData>>
}