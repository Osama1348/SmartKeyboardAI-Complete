package com.smartkeyboard.ai

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statusText = findViewById<TextView>(R.id.status_text)
        val enableButton = findViewById<Button>(R.id.enable_button)
        val settingsButton = findViewById<Button>(R.id.settings_button)

        // Check if IME is enabled
        updateStatus(statusText)

        enableButton.setOnClickListener {
            // Open IME settings
            startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
        }

        settingsButton.setOnClickListener {
            // Open app settings
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        val statusText = findViewById<TextView>(R.id.status_text)
        updateStatus(statusText)
    }

    private fun updateStatus(statusText: TextView) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val isEnabled = isKeyboardEnabled()
        
        statusText.text = if (isEnabled) {
            "✓ لوحة المفاتيح مفعلة\nاختر Smart Keyboard AI من إعدادات الإدخال"
        } else {
            "✗ لوحة المفاتيح غير مفعلة\nاضغط على الزر أدناه لتفعيلها"
        }
    }

    private fun isKeyboardEnabled(): Boolean {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val enabledMethods = Settings.Secure.getString(
            contentResolver,
            Settings.Secure.ENABLED_INPUT_METHODS
        ) ?: ""
        return enabledMethods.contains("com.smartkeyboard.ai/.SmartKeyboardIME")
    }
}
