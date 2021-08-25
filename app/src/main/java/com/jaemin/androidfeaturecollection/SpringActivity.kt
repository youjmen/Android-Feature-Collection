package com.jaemin.androidfeaturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce

class SpringActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring)
        val layout = findViewById<ViewGroup>(R.id.spring_layout)
        val springAnim = SpringAnimation(layout, DynamicAnimation.TRANSLATION_Y, 0f)
        springAnim.spring.dampingRatio = SpringForce.DAMPING_RATIO_LOW_BOUNCY
        springAnim.spring.stiffness = SpringForce.STIFFNESS_LOW

        springAnim.start()
    }
}