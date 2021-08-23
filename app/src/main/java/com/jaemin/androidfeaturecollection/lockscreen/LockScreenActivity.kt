package com.jaemin.androidfeaturecollection.lockscreen

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.Button
import com.jaemin.androidfeaturecollection.R

class LockScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O_MR1){
//            setShowWhenLocked(true)
//            setTurnScreenOn(true)
//        }
//        else {
//            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
//            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
//
//        }
        setContentView(R.layout.activity_lock_screen)
        findViewById<Button>(R.id.btn_start_service).setOnClickListener {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
                startForegroundService(Intent(this, LockScreenService::class.java))
            }
            else{
                startService(Intent(this, LockScreenService::class.java))
            }
        }
        findViewById<Button>(R.id.btn_stop_service).setOnClickListener {
            stopService(Intent(this, LockScreenService::class.java))
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return when(event!!.action){
            MotionEvent.ACTION_MOVE ->{
                finish()
                true
            }
            else -> super.onTouchEvent(event)
        }
    }
}