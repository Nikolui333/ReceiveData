package com.sem.receivedata.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.sem.receivedata.data.dataSource.PaginationDataSource
import com.sem.receivedata.data.localDB.PaginationDao
import com.sem.receivedata.data.models.PaginationLocalModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaginationDataSourceIMPL (private val dao: PaginationDao):
    PaginationDataSource {

    override fun insert(paginationLocalModel: PaginationLocalModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(paginationLocalModel)}
    }

    override fun loadPagination(): LiveData<List<PaginationLocalModel>> {
        return dao.loadPagination()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }


}