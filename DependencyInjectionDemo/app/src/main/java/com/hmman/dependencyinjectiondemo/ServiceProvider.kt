package com.hmman.dependencyinjectiondemo

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {

    init {
        Log.i("mytag", "ServiceProvider contructed")
    }

    fun getServiceProvider() {
        Log.i("mytag", "ServiceProvider connected")
    }
}