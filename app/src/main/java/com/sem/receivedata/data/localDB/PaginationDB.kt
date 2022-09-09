package com.sem.receivedata.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sem.receivedata.data.models.PaginationLocalModel

@Database(entities = [PaginationLocalModel::class], version = 1)
abstract class PaginationDB : RoomDatabase() {

    abstract val paginationDao : PaginationDao

}