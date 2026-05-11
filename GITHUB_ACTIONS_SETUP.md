# إعداد GitHub Actions لبناء APK تلقائياً

## الخطوات:

### 1. إنشاء ملف Workflow يدويًا

1. اذهب إلى مستودعك على GitHub:
   https://github.com/Osama1348/SmartKeyboardAI

2. اضغط على **Actions** في الشريط العلوي

3. اضغط **New workflow**

4. اختر **set up a workflow yourself**

5. انسخ الكود التالي في الملف:

```yaml
name: Build APK

on:
  push:
    branches: [ master, main, develop ]
  pull_request:
    branches: [ master, main, develop ]
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3

    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'
        cache: gradle

    - name: Make gradlew executable
      run: chmod +x ./gradlew

    - name: Build Debug APK
      run: ./gradlew assembleDebug

    - name: Build Release APK
      run: ./gradlew assembleRelease

    - name: Upload Debug APK
      uses: actions/upload-artifact@v3
      with:
        name: app-debug
        path: app/build/outputs/apk/debug/app-debug.apk

    - name: Upload Release APK
      uses: actions/upload-artifact@v3
      with:
        name: app-release
        path: app/build/outputs/apk/release/app-release.apk
```

6. اضغط **Commit changes**

7. اختر **Create a new branch for this commit and start a pull request**

8. اضغط **Propose changes**

9. اضغط **Create pull request**

### 2. دمج Pull Request

1. اضغط **Merge pull request**

2. اضغط **Confirm merge**

### 3. تشغيل البناء الأول

1. اذهب إلى **Actions**

2. ستجد **Build APK** workflow

3. اضغط عليه

4. اضغط **Run workflow**

5. اختر **Run workflow**

6. انتظر حتى ينتهي البناء (عادة 5-10 دقائق)

### 4. تحميل APK

1. عند انتهاء البناء، اضغط على اسم البناء

2. ستجد قسم **Artifacts**

3. اضغط على **app-debug** أو **app-release**

4. سيتم تحميل ملف APK

---

## الخيار البديل: استخدام CLI

إذا كنت تفضل استخدام سطر الأوامر:

```bash
# استنساخ المستودع
git clone https://github.com/Osama1348/SmartKeyboardAI.git
cd SmartKeyboardAI

# بناء APK محلياً
./gradlew assembleDebug

# ستجد APK في:
# app/build/outputs/apk/debug/app-debug.apk
```

---

## استكشاف الأخطاء

### المشكلة: البناء فشل مع خطأ "Gradle not found"

**الحل:**
- تأكد من وجود ملفات `gradlew` و `gradle/wrapper/gradle-wrapper.jar`
- إذا كانت مفقودة، أضفها من هذا المستودع

### المشكلة: خطأ في الأذونات

**الحل:**
- تأكد من أن GitHub App لديه أذونات **workflows**
- اذهب إلى **Settings → Actions → General**
- تأكد من تفعيل GitHub Actions

### المشكلة: البناء يستغرق وقتاً طويلاً

**الحل:**
- هذا طبيعي للبناء الأول (قد يستغرق 10-15 دقيقة)
- البناءات التالية ستكون أسرع بسبب التخزين المؤقت

---

## الملفات المطلوبة

تأكد من وجود هذه الملفات في المستودع:

✅ `gradlew` - ملف تنفيذي (Unix)
✅ `gradlew.bat` - ملف تنفيذي (Windows)
✅ `gradle/wrapper/gradle-wrapper.jar` - ملف JAR
✅ `gradle/wrapper/gradle-wrapper.properties` - ملف الخصائص
✅ `build.gradle.kts` - ملف البناء الرئيسي
✅ `app/build.gradle.kts` - ملف بناء التطبيق
✅ `app/src/main/AndroidManifest.xml` - ملف البيان

---

## معلومات إضافية

- **وقت البناء**: 5-15 دقيقة (حسب سرعة الإنترنت)
- **حجم APK**: 25-30 MB (Debug), 15-20 MB (Release)
- **متطلبات**: Java 11+, Android SDK 24+

---

## الدعم

إذا واجهت أي مشاكل:
1. تحقق من [GitHub Issues](https://github.com/Osama1348/SmartKeyboardAI/issues)
2. أنشئ issue جديد مع وصف المشكلة
3. اتصل بفريق الدعم
