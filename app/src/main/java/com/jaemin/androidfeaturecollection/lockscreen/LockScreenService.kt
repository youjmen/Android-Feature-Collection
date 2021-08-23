package com.jaemin.androidfeaturecollection.lockscreen

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import com.jaemin.androidfeaturecollection.R

class LockScreenService : Service() {
    var receiver: ScreenOffReceiver? = null

    private val ANDROID_CHANNEL_ID = "sss"
    private val NOTIFICATION_ID = 9999

    override fun onCreate() {
        super.onCreate()
        if (receiver == null) {
            receiver = ScreenOffReceiver()
            val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
            registerReceiver(receiver, filter)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        if (intent != null) {
            if (receiver == null) {
                receiver = ScreenOffReceiver()
                val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
                registerReceiver(receiver, filter)
            }
        }
        val chan = NotificationChannel(
            ANDROID_CHANNEL_ID,
            "LockScreenService",
            NotificationManager.IMPORTANCE_NONE
        )
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(chan)

        val builder = Notification.Builder(this, ANDROID_CHANNEL_ID)
            .setContentTitle(getString(R.string.app_name))
        val notification = builder.build()

        // Foreground Service 시작!
        startForeground(NOTIFICATION_ID, notification)

        return START_REDELIVER_INTENT
    }
    override fun onDestroy() {
        super.onDestroy()
        if (receiver != null) {
            unregisterReceiver(receiver)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}