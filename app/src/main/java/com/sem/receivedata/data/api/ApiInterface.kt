package com.sem.receivedata.data.api

import com.sem.receivedata.data.models.Data
import com.sem.receivedata.data.models.Pagination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("books?page=1")
    fun loadApi(): Call<ArrayList<Data>>
   // Pagination>

}