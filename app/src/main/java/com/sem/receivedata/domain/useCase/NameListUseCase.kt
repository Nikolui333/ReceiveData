package com.sem.receivedata.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.receivedata.data.models.PaginationLocalModel
import com.sem.receivedata.domain.repository.NameListCall

class NameListUseCase(private val nameListCall: NameListCall) {

    fun loadNameList(): LiveData<List<PaginationLocalModel>> {

        return nameListCall.loadNameList()

    }

    suspend fun startMigration (context: Context) {

        nameListCall.startMigration(context)

    }

}