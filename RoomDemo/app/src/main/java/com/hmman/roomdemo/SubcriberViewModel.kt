package com.hmman.roomdemo

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmman.roomdemo.db.Subcriber
import com.hmman.roomdemo.db.SubcriberRepository
import kotlinx.coroutines.launch

class SubcriberViewModel(private val repository: SubcriberRepository) : ViewModel(), Observable {

    val subcribers = repository.subcribers

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subcriber(0, name, email))
        inputName.value = null
        inputEmail.value = null
    }

    fun clearAllOrDelete() {
        deleteAll()
    }

    fun insert(subcriber: Subcriber) = viewModelScope.launch {
        repository.insert(subcriber)
    }

    fun update(subcriber: Subcriber) = viewModelScope.launch {
        repository.update(subcriber)
    }

    fun delete(subcriber: Subcriber) = viewModelScope.launch {
        repository.delete(subcriber)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}