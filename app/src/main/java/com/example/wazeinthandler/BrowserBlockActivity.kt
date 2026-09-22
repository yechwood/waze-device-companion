package com.example.wazeinthandler

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BrowserBlockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(28, 24, 28, 24)
            setBackgroundColor(0xFFFFFFFF.toInt())
        }

        val message = TextView(this).apply {
            text = "Waze devices don't have browsing."
            textSize = 20f
            setTextColor(0xFF222222.toInt())
        }

        root.addView(message, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ))
        setContentView(root)
    }
}
