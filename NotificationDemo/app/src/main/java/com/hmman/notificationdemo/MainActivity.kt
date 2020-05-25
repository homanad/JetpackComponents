package com.hmman.notificationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    private val channelID = "com.hmman.notificationdemo.channel1"
    private lateinit var notificationManager: NotificationManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelID, "DemoChannel", "This is a demo")
        button.setOnClickListener {
            displayNotification()
        }
    }
    
    private fun displayNotification() {
        val notificationId = 123
        
        val tapResultIntent = Intent(this, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_FORWARD_RESULT
        }
        val pendingIntent =
            PendingIntent.getActivity(this, 0, tapResultIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        
        val notification = NotificationCompat.Builder(this, channelID)
            .setContentTitle("Demo")
            .setContentText("This is a demo")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        
        notificationManager.notify(notificationId, notification)
    }
    
    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager.createNotificationChannel(channel)
        }
    }
}
