package com.hmman.dependencyinjectiondemo

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SIMCard @Inject constructor(val serviceProvider: ServiceProvider) {

    init {
        Log.i("mytag", "SIMCard contructed")
    }

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}