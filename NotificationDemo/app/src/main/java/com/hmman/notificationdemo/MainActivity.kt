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
import androidx.core.app.RemoteInput
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    private lateinit var notificationManager: NotificationManager
    
    companion object {
        val KEY_REPLY = "key_reply"
        val channelID = "com.hmman.notificationdemo.channel1"
        val notificationID = 45
    }
    
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
        //content tap intent
        val tapResultIntent = Intent(this, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_FORWARD_RESULT
        }
        val pendingIntent =
            PendingIntent.getActivity(this, 0, tapResultIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        
        //reply action
        val remoteInput = RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Insert your name here")
            build()
        }
        val replyAction =
            NotificationCompat.Action.Builder(0, "Reply", pendingIntent)
                .addRemoteInput(remoteInput)
                .build()
        
        //action button 1
        val tapIntent1 = Intent(this, DetailsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_FORWARD_RESULT
        }
        val tapPendingIntent1 =
            PendingIntent.getActivity(this, 0, tapIntent1, PendingIntent.FLAG_UPDATE_CURRENT)
        val action1 = NotificationCompat.Action.Builder(0, "Details", tapPendingIntent1).build()
        
        //action button 2
        val tapIntent2 = Intent(this, SettingsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_FORWARD_RESULT
        }
        val tapPendingIntent2 =
            PendingIntent.getActivity(this, 0, tapIntent2, PendingIntent.FLAG_UPDATE_CURRENT)
        val action2 = NotificationCompat.Action.Builder(0, "Settings", tapPendingIntent2).build()
        
        val notification = NotificationCompat.Builder(this, channelID)
            .setContentTitle("Demo")
            .setContentText("This is a demo")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setContentIntent(pendingIntent)
            .addAction(action1)
            .addAction(action2)
            .addAction(replyAction)
            .build()
        
        notificationManager.notify(notificationID, notification)
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
