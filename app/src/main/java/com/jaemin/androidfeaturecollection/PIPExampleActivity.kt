package com.jaemin.androidfeaturecollection

import android.app.PictureInPictureParams
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PIPExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pipexample)
        findViewById<Button>(R.id.button).setOnClickListener {
            if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                val pipParams = PictureInPictureParams.Builder().build()
                enterPictureInPictureMode(pipParams)
            }
        }
    }
}