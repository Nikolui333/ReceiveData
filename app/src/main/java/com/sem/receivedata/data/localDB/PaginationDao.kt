package com.sem.receivedata.data.localDB

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sem.receivedata.data.models.PaginationLocalModel

@Dao
interface PaginationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(paginationLocalModel: PaginationLocalModel)

    @Query("SELECT * FROM pagination_table")
    fun loadPagination() : LiveData<List<PaginationLocalModel>>

    @Query("DELETE FROM pagination_table")
    suspend fun clear()
}