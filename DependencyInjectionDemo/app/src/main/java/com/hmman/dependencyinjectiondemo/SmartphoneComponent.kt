package com.hmman.dependencyinjectiondemo

import dagger.Component
import dagger.Provides
import javax.inject.Singleton

//@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
//interface SmartphoneComponent {
//@Provides
//    fun getSmartphone(): Smartphone
//}

@Singleton
@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartphoneComponent {
    fun inject(mainActivity: MainActivity)
}