package com.example.designpatternmvvm.network

import com.example.designpatternmvvm.model.getAllUserItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    fun getUser() : Call<List<getAllUserItem>>

}