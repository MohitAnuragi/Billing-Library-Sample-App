# 📱 Billing Library Sample App

A clean, modern Android sample application demonstrating how to implement the **Billing-Library** for easy monetization. This app showcases Banner Ads, Interstitials, Rewarded Ads, and Play Store features (In-App Updates & Reviews) using **Kotlin** and **Jetpack Compose**.

## 🚀 Features Demonstrated

* **Banner Ads:** Simple integration in Jetpack Compose.
* **Interstitial Ads:** Load and show full-screen ads.
* **Rewarded Ads:** Handle rewards and callbacks easily.
* **In-App Updates:** Check for app updates with one line of code.
* **In-App Reviews:** Trigger the Play Store review flow.

---

## 🛠️ Setup & Installation

### 1. Add JitPack Repository
Add this to your project-level `settings.gradle.kts` file:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("[https://jitpack.io](https://jitpack.io)") } 
    }
}
```
### 2. Add Dependency
Add the library to your app-level build.gradle.kts:
```
dependencies {
    // Replace  with the latest release 
    implementation("com.github.MohitAnuragi:Billing-Library:1.0.6")
}
```
### 3. Configure Manifest
Add your AdMob App ID to src/main/AndroidManifest.xml. Use the test ID below for development:
```
<manifest ...>
    <application ...>
        
        <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="ca-app-pub-3940256099942544~3347511713" />

    </application>
</manifest>
```

Contact :

Name : Mohit Anuragi

Email : anuragimohit468@gmail.com
