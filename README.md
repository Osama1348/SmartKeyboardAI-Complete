# Smart Keyboard AI - لوحة المفاتيح الذكية

تطبيق لوحة مفاتيح أندرويد ذكي مع تصحيح تلقائي وتحسين أسلوب النصوص العربية باستخدام الذكاء الاصطناعي.

![Version](https://img.shields.io/badge/version-1.0.0-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Android](https://img.shields.io/badge/android-7.0%2B-brightgreen)

---

## 🚀 البدء السريع

### الخيار 1: تحميل APK جاهز (الأسهل)

1. اذهب إلى [Releases](https://github.com/Osama1348/SmartKeyboardAI/releases)
2. حمّل `app-debug.apk` أو `app-release.apk`
3. انسخ الملف إلى هاتفك
4. افتح الملف واضغط **تثبيت**

### الخيار 2: بناء من المصدر

```bash
git clone https://github.com/Osama1348/SmartKeyboardAI.git
cd SmartKeyboardAI
./gradlew assembleDebug
# ستجد APK في: app/build/outputs/apk/debug/app-debug.apk
```

### الخيار 3: بناء تلقائي مع GitHub Actions

اتبع [تعليمات GitHub Actions](GITHUB_ACTIONS_SETUP.md) لإعداد البناء التلقائي.

---

## 📱 التثبيت على الهاتف

### المتطلبات الأولية:
1. فعّل **مصادر غير معروفة**: الإعدادات → الأمان
2. انسخ ملف APK إلى هاتفك

### خطوات التثبيت:
1. افتح **مدير الملفات**
2. ابحث عن ملف `app-debug.apk`
3. اضغط عليه واختر **تثبيت**

### تفعيل لوحة المفاتيح:
1. افتح التطبيق
2. اضغط **تفعيل لوحة المفاتيح**
3. الإعدادات → النظام → اللغات والإدخال → لوحات المفاتيح
4. اختر **Smart Keyboard AI**

---

## ✨ الميزات

✅ **التصحيح التلقائي** - تصحيح الأخطاء الإملائية والنحوية
✅ **الصياغة الأدبية** - تحسين الأسلوب بأسلوب بليغ
✅ **لوحة مفاتيح عربية كاملة** - جميع الحروف العربية
✅ **تكامل الذكاء الاصطناعي** - استخدام Claude AI API
✅ **إعدادات متقدمة** - تحكم كامل بالميزات

---

## 📚 التوثيق

| الملف | الوصف |
|------|-------|
| [BUILD_INSTRUCTIONS.md](BUILD_INSTRUCTIONS.md) | تعليمات البناء الكاملة (3 طرق) |
| [GITHUB_ACTIONS_SETUP.md](GITHUB_ACTIONS_SETUP.md) | إعداد البناء التلقائي |
| [README_AR.md](README_AR.md) | دليل عربي شامل |

---

## 🛠️ المتطلبات

- **نظام التشغيل**: Android 7.0 (API 24) أو أحدث
- **الذاكرة**: 100 MB على الأقل
- **الاتصال**: إنترنت نشط (لاستخدام AI)

---

## 📊 معلومات المشروع

| المعلومة | القيمة |
|---------|--------|
| الإصدار | 1.0.0 |
| Min SDK | 24 (Android 7.0) |
| Target SDK | 34 (Android 14) |
| حجم APK | 25-30 MB |
| اللغة | Kotlin |
| الترخيص | MIT |

---

## 🏗️ هيكل المشروع

```
SmartKeyboardAI/
├── app/
│   ├── src/main/
│   │   ├── java/com/smartkeyboard/ai/
│   │   │   ├── MainActivity.kt
│   │   │   ├── SmartKeyboardIME.kt
│   │   │   ├── AITextProcessor.kt
│   │   │   └── SettingsActivity.kt
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   ├── values/
│   │   │   └── xml/
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/wrapper/
├── build.gradle.kts
├── gradlew
├── gradlew.bat
└── README.md
```

---

## 🔧 التكنولوجيات المستخدمة

- **Kotlin** - لغة البرمجة
- **Android SDK** - إطار عمل أندرويد
- **Retrofit** - لـ API calls
- **Coroutines** - للعمليات غير المتزامنة
- **Claude AI API** - للمعالجة الذكية

---

## 🤝 المساهمة

نرحب بالمساهمات! يمكنك:

1. [الإبلاغ عن المشاكل](https://github.com/Osama1348/SmartKeyboardAI/issues)
2. عمل Fork والمساهمة بـ Pull Request
3. تحسين التوثيق

---

## 📄 الترخيص

MIT License - انظر ملف LICENSE للتفاصيل.

---

## 📞 الدعم

- 📖 [تعليمات البناء](BUILD_INSTRUCTIONS.md)
- 🔧 [إعداد GitHub Actions](GITHUB_ACTIONS_SETUP.md)
- 🐛 [الإبلاغ عن المشاكل](https://github.com/Osama1348/SmartKeyboardAI/issues)

---

**آخر تحديث**: مايو 2026 | **المطور**: Smart Keyboard AI Team
