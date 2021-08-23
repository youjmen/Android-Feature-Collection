package com.jaemin.androidfeaturecollection.lockscreen

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ScreenOffReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_SCREEN_OFF -> {
                val lockIntent = Intent(context, LockScreenActivity::class.java)
                lockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                lockIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                context?.startActivity(intent)
            }
        }
    }
}