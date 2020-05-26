package com.hmman.dependencyinjectiondemo

import dagger.Binds
import dagger.Module
import dagger.Provides

//@Module
//class NCBatteryModule {
//    @Provides
//    fun providesNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery {
//        return nickelCadmiumBattery
//    }
//}

@Module
abstract class NCBatteryModule {
    @Binds
    abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}