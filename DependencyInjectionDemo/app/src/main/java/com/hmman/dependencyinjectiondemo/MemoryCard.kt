package com.hmman.dependencyinjectiondemo

import android.util.Log

class MemoryCard {

    init {
        Log.i("mytag", "MemoryCard contructed")
    }

    fun getSpaceAvaibility() {
        Log.i("mytag", "Memory space available")
    }
}