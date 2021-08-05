package com.jaemin.androidfeaturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class PreventScreenshotExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prevent_screenshot_example)
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }
}