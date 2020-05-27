package com.hmman.dependencyinjectiondemo

import android.app.Application

class SmartphoneApplication : Application() {

    lateinit var smartPhoneComponent: SmartphoneComponent

    override fun onCreate() {
        smartPhoneComponent = initDagger()
        super.onCreate()
    }

    private fun initDagger(): SmartphoneComponent =
        DaggerSmartphoneComponent.builder()
            .memoryCardModule(MemoryCardModule(1024))
            .build()

}