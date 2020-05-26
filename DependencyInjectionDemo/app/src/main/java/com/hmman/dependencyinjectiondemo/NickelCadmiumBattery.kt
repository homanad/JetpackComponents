package com.hmman.dependencyinjectiondemo

import android.util.Log
import javax.inject.Inject

class NickelCadmiumBattery @Inject constructor() : Battery {
    override fun getPower() {
        Log.i("mytag", "Power from NickelCadmiumBattery")
    }
}