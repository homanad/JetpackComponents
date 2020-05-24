package com.hmman.roomdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hmman.roomdemo.db.SubcriberRepository

class SubcriberViewModelFactory(private val reposiroty: SubcriberRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubcriberViewModel::class.java)) {
            return SubcriberViewModel(reposiroty) as T
        }
        throw IllegalAccessException("Unknown View Model class")
    }
}