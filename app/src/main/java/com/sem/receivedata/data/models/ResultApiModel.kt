package com.sem.receivedata.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultApiModel {

    @SerializedName("data") @Expose
    val data: ArrayList<Data>? = null

}