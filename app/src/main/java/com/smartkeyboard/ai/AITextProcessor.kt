package com.smartkeyboard.ai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import com.google.gson.annotations.SerializedName

// API Models
data class ChatMessage(
    val role: String,
    val content: String
)

data class ChatRequest(
    val model: String,
    val messages: List<ChatMessage>,
    val stream: Boolean = false
)

data class ChatChoice(
    val message: ChatMessage,
    val finish_reason: String
)

data class ChatResponse(
    val choices: List<ChatChoice>
)

// Retrofit Service
interface AIService {
    @POST("chat/completions")
    suspend fun correctText(
        @Header("Authorization") auth: String,
        @Body request: ChatRequest
    ): ChatResponse
}

class AITextProcessor {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.anthropic.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    
    private val service = retrofit.create(AIService::class.java)
    private val apiKey = "YOUR_API_KEY_HERE" // Will be set from settings
    
    suspend fun correctText(text: String): String = withContext(Dispatchers.IO) {
        try {
            val request = ChatRequest(
                model = "claude-sonnet-4-5",
                messages = listOf(
                    ChatMessage(
                        role = "system",
                        content = """أنت محرر نصوص عربي ذكي. مهمتك تصحيح الأخطاء الإملائية والنحوية مع الحفاظ على المعنى الأصلي.
                        - لا تكتب أي مقدمة
                        - أعد النص المصحح فقط"""
                    ),
                    ChatMessage(
                        role = "user",
                        content = text
                    )
                )
            )
            
            val response = service.correctText(
                "Bearer $apiKey",
                request
            )
            
            response.choices.firstOrNull()?.message?.content ?: text
        } catch (e: Exception) {
            // Return original text if API fails
            text
        }
    }
    
    suspend fun improveStyle(text: String): String = withContext(Dispatchers.IO) {
        try {
            val request = ChatRequest(
                model = "claude-sonnet-4-5",
                messages = listOf(
                    ChatMessage(
                        role = "system",
                        content = """أنت كاتب أدبي متخصص. مهمتك إعادة صياغة النصوص بأسلوب أدبي بليغ.
                        - لا تكتب أي مقدمة
                        - أعد النص المحسّن فقط"""
                    ),
                    ChatMessage(
                        role = "user",
                        content = text
                    )
                )
            )
            
            val response = service.correctText(
                "Bearer $apiKey",
                request
            )
            
            response.choices.firstOrNull()?.message?.content ?: text
        } catch (e: Exception) {
            // Return original text if API fails
            text
        }
    }
}
