package com.example.wazeinthandler

import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showNumber(intent?.data)
    }

    override fun onNewIntent(intent: android.content.Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        showNumber(intent?.data)
    }

    private fun showNumber(uri: Uri?) {
        val number = uri?.schemeSpecificPart
            ?.let(Uri::decode)
            ?.ifBlank { "No phone number supplied" }
            ?: "No phone number supplied"

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(28, 20, 28, 20)
            setBackgroundColor(0xFFFFFFFF.toInt())
        }

        val message = TextView(this).apply {
            text = number
            textSize = 20f
            setTextColor(0xFF222222.toInt())
            setPadding(0, 8, 0, 8)
        }

        root.addView(message, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ))
        setContentView(root)
    }
}
