# تعليمات بناء تطبيق Smart Keyboard AI - APK

## المتطلبات

- **Android Studio** (أحدث إصدار)
- **Java Development Kit (JDK) 11+**
- **Android SDK 24+**
- **Gradle 8.1+**

---

## الطريقة 1: استخدام Android Studio (الأسهل)

### الخطوة 1: تحميل Android Studio
1. اذهب إلى: https://developer.android.com/studio
2. حمّل Android Studio لنظام التشغيل الخاص بك
3. ثبّت البرنامج

### الخطوة 2: استيراد المشروع
1. افتح Android Studio
2. اختر **File → Open**
3. اختر مجلد المشروع `SmartKeyboardAI`
4. انتظر حتى ينتهي Gradle من التحميل (قد يستغرق 5-10 دقائق)

### الخطوة 3: بناء APK
1. اذهب إلى **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. انتظر حتى ينتهي البناء
3. ستظهر رسالة "Build successful"
4. اضغط على **Locate** لفتح مجلد APK

### الخطوة 4: البحث عن APK
- المسار: `SmartKeyboardAI/app/build/outputs/apk/debug/app-debug.apk`
- أو للإصدار النهائي: `SmartKeyboardAI/app/build/outputs/apk/release/app-release.apk`

---

## الطريقة 2: استخدام سطر الأوامر (للمتقدمين)

### الخطوة 1: تثبيت المتطلبات
```bash
# تثبيت JDK 11
# على Windows: https://www.oracle.com/java/technologies/downloads/#java11
# على Mac: brew install openjdk@11
# على Linux: sudo apt-get install openjdk-11-jdk

# تثبيت Android SDK
# اتبع التعليمات على: https://developer.android.com/studio/command-line/sdkmanager
```

### الخطوة 2: تعيين متغيرات البيئة
```bash
# على Windows (في PowerShell):
$env:ANDROID_HOME = "C:\Users\YourUsername\AppData\Local\Android\Sdk"
$env:JAVA_HOME = "C:\Program Files\Java\jdk-11.0.x"

# على Mac/Linux:
export ANDROID_HOME=$HOME/Android/Sdk
export JAVA_HOME=/usr/libexec/java_home -v 11
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

### الخطوة 3: بناء APK
```bash
# انتقل إلى مجلد المشروع
cd SmartKeyboardAI

# بناء APK للتطوير (debug)
./gradlew assembleDebug

# أو بناء APK للإصدار النهائي (release)
./gradlew assembleRelease
```

### الخطوة 4: البحث عن APK
```bash
# على Windows:
dir app\build\outputs\apk\debug\

# على Mac/Linux:
ls -la app/build/outputs/apk/debug/
```

---

## الطريقة 3: استخدام GitHub Actions (تلقائي)

### الخطوة 1: تفعيل GitHub Actions
1. اذهب إلى: https://github.com/Osama1348/SmartKeyboardAI
2. اذهب إلى **Settings → Actions → General**
3. تأكد من تفعيل GitHub Actions

### الخطوة 2: إنشاء Release
1. اذهب إلى **Releases**
2. اضغط **Create a new release**
3. أدخل رقم الإصدار (مثل `v1.0.0`)
4. اضغط **Publish release**

### الخطوة 3: انتظر البناء
1. اذهب إلى **Actions**
2. شاهد البناء يتقدم
3. عند الانتهاء، سيكون APK متاحاً في Release

---

## خطوات التثبيت على هاتفك

### قبل التثبيت:
1. **فعّل "مصادر غير معروفة"**:
   - الإعدادات → الأمان → السماح بتثبيت التطبيقات من مصادر غير معروفة
   - أو: الإعدادات → التطبيقات → السماح بالتثبيت من ملفات غير معروفة

2. **انسخ ملف APK** إلى هاتفك

### التثبيت:
1. افتح **مدير الملفات** على هاتفك
2. ابحث عن ملف `app-debug.apk` أو `app-release.apk`
3. اضغط عليه لتثبيت التطبيق
4. اضغط **تثبيت**

### تفعيل لوحة المفاتيح:
1. افتح التطبيق
2. اضغط **تفعيل لوحة المفاتيح**
3. اذهب إلى الإعدادات → النظام → اللغات والإدخال → لوحات المفاتيح
4. اختر **Smart Keyboard AI**

---

## استكشاف الأخطاء

### المشكلة: "Gradle not found"
**الحل:**
```bash
# على Windows:
gradlew.bat assembleDebug

# على Mac/Linux:
./gradlew assembleDebug
```

### المشكلة: "Android SDK not found"
**الحل:**
1. افتح Android Studio
2. اذهب إلى **Tools → SDK Manager**
3. تأكد من تثبيت SDK 24+ و Build Tools

### المشكلة: "Java version not compatible"
**الحل:**
```bash
# تحقق من إصدار Java
java -version

# تأكد من استخدام JDK 11+
# إذا كان أقل من 11، حمّل JDK 11 من:
# https://www.oracle.com/java/technologies/downloads/#java11
```

### المشكلة: "Build failed"
**الحل:**
```bash
# نظّف المشروع وأعد البناء
./gradlew clean
./gradlew assembleDebug
```

---

## معلومات إضافية

### حجم APK:
- **Debug APK**: ~25-30 MB
- **Release APK**: ~15-20 MB (بعد التحسين)

### الإصدار الحالي:
- **Version Code**: 1
- **Version Name**: 1.0.0
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)

### الميزات المتضمنة:
✅ لوحة مفاتيح عربية كاملة
✅ تكامل مع Claude AI API
✅ تصحيح تلقائي
✅ تحسين الأسلوب الأدبي
✅ إعدادات متقدمة

---

## الدعم

إذا واجهت أي مشاكل:
1. تحقق من [GitHub Issues](https://github.com/Osama1348/SmartKeyboardAI/issues)
2. أنشئ issue جديد مع وصف المشكلة
3. اتصل بفريق الدعم

---

## الترخيص

هذا المشروع مرخص تحت MIT License
