package com.sem.receivedata.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.receivedata.data.dataSource.ApiDataSource
import com.sem.receivedata.data.dataSource.PaginationDataSource
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.domain.repository.NameListCall

class NameListRepository (private val apiDataSource: ApiDataSource,
                          private val dataSource: PaginationDataSource,
) : NameListCall {

    override fun loadNameList(): LiveData<List<PaginationLocalModel>> {
        return dataSource.loadPagination()
    }

    override suspend fun startMigration(context: Context) {
        dataSource.clear()
        apiDataSource.startMigration(context)
    }


}