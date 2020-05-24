package com.hmman.roomdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.hmman.roomdemo.dbthis.SubcriberDAO

@Database(entities = [Subcriber::class], version = 1)
abstract class SubcriberDatabase : RoomDatabase() {

    abstract val subcriberDAO: SubcriberDAO

    companion object {
        @Volatile
        private var INSTANCE: SubcriberDatabase? = null
        const val SUBCRIBER_DATABASE = "subcriber_data_database"

        fun getInstance(context: Context): SubcriberDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = databaseBuilder(
                        context.applicationContext,
                        SubcriberDatabase::class.java,
                        SUBCRIBER_DATABASE
                    ).build()
                }
                return instance
            }
        }
    }

}