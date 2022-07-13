package com.example.retrofitrestapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("albums/1/photos")
    fun getData(): Call<List<dataItem>>
}