package com.sem.receivedata.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.receivedata.data.dataSource.ApiDataSource
import com.sem.receivedata.data.dataSource.RDDataSource
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.domain.repository.NameListCall

class NameListRepository (private val apiDataSource: ApiDataSource,
                          private val dataSource: RDDataSource,
) : NameListCall {

    override fun loadNameList(): LiveData<List<PaginationLocalModel>> {
        return dataSource.loadNameList()
    }

    override suspend fun startMigration(context: Context) {
        dataSource.clear()
        apiDataSource.startMigration(context)
    }


}