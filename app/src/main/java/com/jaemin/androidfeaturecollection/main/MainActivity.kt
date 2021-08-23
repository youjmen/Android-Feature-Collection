package com.jaemin.androidfeaturecollection.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jaemin.androidfeaturecollection.PIPExampleActivity
import com.jaemin.androidfeaturecollection.PreventScreenshotExampleActivity
import com.jaemin.androidfeaturecollection.R
import com.jaemin.androidfeaturecollection.biometric.FingerPrintAuthenticationActivity
import com.jaemin.androidfeaturecollection.databinding.ActivityMainBinding
import com.jaemin.androidfeaturecollection.lockscreen.LockScreenActivity
import com.jaemin.androidfeaturecollection.notification.NotificationActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = MainAdapter()
        binding.rvMain.adapter = adapter
        val list = listOf<Pair<String,Class<*>>>(Pair("LockScreen", LockScreenActivity::class.java),
            Pair("Biometric", FingerPrintAuthenticationActivity::class.java),
            Pair("Notification", NotificationActivity::class.java),
            Pair("PIP", PIPExampleActivity::class.java),
            Pair("PreventScreenshot", PreventScreenshotExampleActivity::class.java)
        )
        adapter.addItems(list)
        binding.btnAdd.setOnClickListener {
            adapter.addItem(Pair("PreventScreenshot", PreventScreenshotExampleActivity::class.java))

        }

    }
}