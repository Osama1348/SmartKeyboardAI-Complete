package com.smartkeyboard.ai

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.FrameLayout
import kotlinx.coroutines.*

class SmartKeyboardIME : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    
    private lateinit var keyboardView: KeyboardView
    private lateinit var keyboard: Keyboard
    private var lastWord = StringBuilder()
    private val scope = CoroutineScope(Dispatchers.Main + Job())
    private val apiService = AITextProcessor()

    override fun onCreateInputView(): View {
        val container = FrameLayout(this)
        
        keyboardView = KeyboardView(this)
        keyboard = Keyboard(this, R.xml.keyboard_layout)
        keyboardView.keyboard = keyboard
        keyboardView.setOnKeyboardActionListener(this)
        
        container.addView(keyboardView)
        return container
    }

    override fun onPress(primaryCode: Int) {
        // Haptic feedback
        keyboardView.performHapticFeedback(
            android.view.HapticFeedbackConstants.KEYBOARD_TAP
        )
    }

    override fun onRelease(primaryCode: Int) {
        // No action needed
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val ic = currentInputConnection ?: return

        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> {
                // Delete key
                ic.deleteSurroundingText(1, 0)
                lastWord.deleteCharAt(lastWord.length - 1)
            }
            Keyboard.KEYCODE_SHIFT -> {
                // Shift key - toggle caps
                keyboard.setShifted(!keyboard.isShifted)
                keyboardView.invalidateAllKeys()
            }
            32 -> {
                // Space - trigger correction if enabled
                ic.commitText(" ", 1)
                lastWord.clear()
            }
            else -> {
                // Regular character
                val code = primaryCode.toChar()
                ic.commitText(code.toString(), 1)
                lastWord.append(code)
                
                // Auto-correct after 3 characters
                if (lastWord.length >= 3) {
                    triggerAutoCorrection(ic)
                }
            }
        }
    }

    override fun onText(text: CharSequence?) {
        val ic = currentInputConnection ?: return
        ic.commitText(text, 1)
    }

    override fun swipeLeft() {
        // Switch to previous input method
        val imm = getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
        imm.switchToLastInputMethod(window.window?.attributes?.token)
    }

    override fun swipeRight() {
        // Switch to next input method
        val imm = getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
        imm.switchToNextInputMethod(window.window?.attributes?.token)
    }

    override fun swipeDown() {
        // Hide keyboard
        requestHideSelf(0)
    }

    override fun swipeUp() {
        // Show keyboard settings
    }

    private fun triggerAutoCorrection(ic: InputConnection) {
        val text = lastWord.toString()
        
        scope.launch {
            try {
                val corrected = apiService.correctText(text)
                if (corrected != text) {
                    // Delete original text
                    ic.deleteSurroundingText(text.length, 0)
                    // Insert corrected text
                    ic.commitText(corrected, 1)
                    lastWord.clear()
                    lastWord.append(corrected)
                }
            } catch (e: Exception) {
                // Silently fail - don't interrupt user input
            }
        }
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}
