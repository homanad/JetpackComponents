package com.hmman.roomdemo.db

import com.hmman.roomdemo.dbthis.SubcriberDAO

class SubcriberRepository(private val dao: SubcriberDAO) {

    val subcribers = dao.getAllSubcribers()

    suspend fun insert(subcriber: Subcriber) {
        dao.insertSubcriber(subcriber)
    }

    suspend fun update(subcriber: Subcriber) {
        dao.updateSubcriber(subcriber)
    }

    suspend fun delete(subcriber: Subcriber) {
        dao.deleteSubcriber(subcriber)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

}