package com.hmman.dependencyinjectiondemo

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize: Int) {

    @Provides
    fun providesMemoryCard(): MemoryCard {
        Log.i("mytag", "Size of the memory is $memorySize")
        return MemoryCard()
    }

}