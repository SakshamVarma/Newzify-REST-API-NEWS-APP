package com.example.apitest

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("top-headlines?country=in&apiKey=f99efcc9ddfe432ea5382d59aa6bb7ea")
    fun getData() : Call<NewsClass>
}