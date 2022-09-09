package com.sem.receivedata.data.repository

import androidx.lifecycle.LiveData
import com.sem.receivedata.data.dataSource.DescriptionDataSource
import com.sem.receivedata.data.dataSource.RDDataSource
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.domain.repository.DescriptionCall

class DescriptionRepository(private val dataSource: RDDataSource
/*private val dataSource: DescriptionDataSource*/) : DescriptionCall {

    override fun loadDescription(): LiveData<List<PaginationLocalModel>> {
        return dataSource.loadNameList()
       // loadDescription()
    }

}