package com.sem.receivedata.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.sem.receivedata.data.dataSource.RDDataSource
import com.sem.receivedata.data.localDB.NameListDao
import com.sem.receivedata.data.models.Pagination
import com.sem.receivedata.data.models.PaginationLocalModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataSourceIMPL (private val dao: NameListDao):
    RDDataSource {

    override fun insert(paginationLocalModel: PaginationLocalModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(paginationLocalModel)}
    }

    override fun loadNameList(): LiveData<List<PaginationLocalModel>> {
        return dao.loadNameList()
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }


}