package com.example.wazeinthandler

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureTransparentWindow()
        showNumber(intent?.data)
    }

    override fun onNewIntent(intent: android.content.Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        showNumber(intent?.data)
    }

    private fun configureTransparentWindow() {
        window.setBackgroundDrawableResource(android.R.color.transparent)
        window.setDimAmount(0f)
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    private fun showNumber(uri: Uri?) {
        val number = uri?.schemeSpecificPart
            ?.let(Uri::decode)
            ?.trim()
            ?.removePrefix("{")
            ?.removeSuffix("}")
            ?.trim()
            ?.ifBlank { "No phone number supplied" }
            ?: "No phone number supplied"

        val root = FrameLayout(this).apply {
            setBackgroundColor(Color.TRANSPARENT)
        }

        val numberBackground = GradientDrawable().apply {
            setColor(Color.WHITE)
            cornerRadius = 8f
        }

        val message = TextView(this).apply {
            text = number
            textSize = 20f
            setTextColor(Color.rgb(34, 34, 34))
            gravity = Gravity.CENTER
            setPadding(22, 12, 22, 12)
            background = numberBackground
        }

        root.addView(
            message,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
            )
        )

        setContentView(root)
    }
}
