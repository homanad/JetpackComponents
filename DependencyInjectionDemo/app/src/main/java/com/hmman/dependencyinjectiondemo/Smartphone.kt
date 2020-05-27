package com.hmman.dependencyinjectiondemo

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Smartphone @Inject constructor(
    val battery: Battery,
    val simCard: SIMCard,
    val memoryCard: MemoryCard
) {

    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvaibility()
        Log.i("mytag", "Smartphone contructed")
    }

    fun makeACallWithRecording() {
        Log.i("mytag", "Calling...")
    }
}