package com.sem.receivedata.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.sem.receivedata.data.models.PaginationLocalModel

@Dao
interface DescriptionDao {

    @Query("SELECT * FROM pagination_table")
    fun loadDescription() : LiveData<List<PaginationLocalModel>>

}