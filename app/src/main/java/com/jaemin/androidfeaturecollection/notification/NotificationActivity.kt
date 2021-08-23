package com.jaemin.androidfeaturecollection.notification

import android.app.Activity
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.jaemin.androidfeaturecollection.R

class NotificationActivity : AppCompatActivity() {
    private lateinit var builder : Notification
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        createNotificationChannel()
        builder = createNotification()
        builder.flags = Notification.FLAG_NO_CLEAR
        with(NotificationManagerCompat.from(this)){
            notify(1, builder)
        }
    }

    fun createNotification() : Notification{
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setSubText("test")
            .setContentText("dsfasf")
            .setContentTitle("dsafsadf")
            .setOngoing(true)
            .build()
    }
    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel1)
            val descriptionText = getString(R.string.app_name)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    companion object{
        const val CHANNEL_ID = "SAMPLE"
    }
}
