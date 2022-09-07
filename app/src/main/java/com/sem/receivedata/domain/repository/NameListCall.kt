package com.sem.receivedata.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.receivedata.data.models.PaginationLocalModel

interface NameListCall {

    fun loadNameList(): LiveData<List<PaginationLocalModel>>
    suspend fun startMigration(context: Context)

}