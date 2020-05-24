package com.hmman.roomdemo.dbthis

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hmman.roomdemo.db.Subcriber

@Dao
interface SubcriberDAO {

    //    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    suspend fun insertSubcriber(subcriber: Subcriber): Long

    @Update
    suspend fun updateSubcriber(subcriber: Subcriber)

    @Delete
    suspend fun deleteSubcriber(subcriber: Subcriber)

    @Query("DELETE FROM ${Subcriber.TABLE_NAME}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${Subcriber.TABLE_NAME}")
    fun getAllSubcribers(): LiveData<List<Subcriber>>

}