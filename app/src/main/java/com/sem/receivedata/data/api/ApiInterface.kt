package com.sem.receivedata.data.api

import com.sem.receivedata.data.models.PaginationApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("books?page=1")
    fun loadApi(): Call<PaginationApiModel>

}