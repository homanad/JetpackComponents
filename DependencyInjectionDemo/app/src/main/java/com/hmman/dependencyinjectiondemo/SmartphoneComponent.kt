package com.hmman.dependencyinjectiondemo

import dagger.Component
import dagger.Provides

//@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
//interface SmartphoneComponent {
//@Provides
//    fun getSmartphone(): Smartphone
//}

@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartphoneComponent {
    fun inject(mainActivity: MainActivity)
}