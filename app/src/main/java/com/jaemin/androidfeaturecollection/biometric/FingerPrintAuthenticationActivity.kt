package com.jaemin.androidfeaturecollection.biometric

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.jaemin.androidfeaturecollection.R

class FingerPrintAuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finger_print_authentication)
        val executor = ContextCompat.getMainExecutor(this)


        val biometricPrompt  = BiometricPrompt(this, executor, object  : BiometricPrompt.AuthenticationCallback(){

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)

            }
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(this@FingerPrintAuthenticationActivity, "성공", Toast.LENGTH_SHORT).show()

            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }

        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("지문 인식")
            .setSubtitle("지문을 인식해주세요.")
            .setNegativeButtonText("안돼")
            .build()

        biometricPrompt.authenticate(promptInfo)
    }
}