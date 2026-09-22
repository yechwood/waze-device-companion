package com.example.wazeinthandler

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BrowserBlockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = FrameLayout(this).apply {
            setBackgroundColor(Color.WHITE)
        }

        val message = TextView(this).apply {
            text = "Waze devices don't have browsing."
            textSize = 20f
            setTextColor(Color.rgb(34, 34, 34))
            gravity = Gravity.CENTER
        }

        root.addView(
            message,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
            )
        )

        setContentView(root)
    }
}
