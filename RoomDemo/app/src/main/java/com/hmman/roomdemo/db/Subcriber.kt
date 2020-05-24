package com.hmman.roomdemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Subcriber.TABLE_NAME)
data class Subcriber(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SUBCRIBER_ID)
    val id: Int,

    @ColumnInfo(name = SUBCRIBER_NAME)
    val name: String,

    @ColumnInfo(name = SUBCRIBER_EMAIL)
    val email: String

) {
    companion object {
        const val TABLE_NAME = "subcriber_data_table"
        const val SUBCRIBER_ID = "subcriber_id"
        const val SUBCRIBER_NAME = "subcriber_name"
        const val SUBCRIBER_EMAIL = "subcriber_email"
    }
}