package com.sem.receivedata.data.dataSource

import androidx.lifecycle.LiveData
import com.sem.receivedata.data.models.PaginationLocalModel

interface RDDataSource {

    fun insert(paginationLocalModel: PaginationLocalModel)

    fun loadNameList(): LiveData<List<PaginationLocalModel>>

    suspend fun clear()

}