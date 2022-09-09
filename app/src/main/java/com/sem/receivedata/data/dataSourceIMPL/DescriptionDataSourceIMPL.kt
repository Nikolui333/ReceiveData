package com.sem.receivedata.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.sem.receivedata.data.dataSource.DescriptionDataSource
import com.sem.receivedata.data.localDB.DescriptionDao
import com.sem.receivedata.data.localDB.NameListDao
import com.sem.receivedata.data.models.PaginationLocalModel

class DescriptionDataSourceIMPL(private val dao: DescriptionDao): DescriptionDataSource {
    override fun loadDescription(): LiveData<List<PaginationLocalModel>> {
        return dao.loadDescription()
    }

}