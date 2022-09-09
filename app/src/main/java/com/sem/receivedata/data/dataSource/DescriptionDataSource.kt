package com.sem.receivedata.data.dataSource

import androidx.lifecycle.LiveData
import com.sem.receivedata.data.models.PaginationLocalModel

interface DescriptionDataSource {

    fun loadDescription(): LiveData<List<PaginationLocalModel>>

}