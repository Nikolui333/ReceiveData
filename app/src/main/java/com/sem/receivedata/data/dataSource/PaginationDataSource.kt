package com.sem.receivedata.data.dataSource

import androidx.lifecycle.LiveData
import com.sem.receivedata.data.models.PaginationLocalModel

interface PaginationDataSource {

    fun insert(paginationLocalModel: PaginationLocalModel)

    fun loadPagination(): LiveData<List<PaginationLocalModel>>

    suspend fun clear()

}