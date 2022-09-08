package com.sem.receivedata.domain.repository

import androidx.lifecycle.LiveData
import com.sem.receivedata.data.models.PaginationLocalModel

interface DescriptionCall {

    fun loadDescription(): LiveData<List<PaginationLocalModel>>

}