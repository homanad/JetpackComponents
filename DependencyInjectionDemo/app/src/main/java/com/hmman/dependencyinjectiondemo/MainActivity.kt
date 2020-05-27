package com.hmman.dependencyinjectiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: Smartphone

    @Inject
    lateinit var simCard: SIMCard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        DaggerSmartphoneComponent.create()
//            .inject(this)
//        smartPhone.makeACallWithRecording()

//        simCard.getConnection()

//        DaggerSmartphoneComponent.builder()
//            .memoryCardModule(MemoryCardModule(1024))
//            .build()
//            .inject(this)

        (application as SmartphoneApplication).smartPhoneComponent
            .inject(this)
        smartPhone.makeACallWithRecording()
    }
}
