object Versions {
    const val kotlin = "1.5.10"
    const val coroutines = "1.5.0"
    const val gradlePlugin: String = "4.0.2"
    const val glide: String = "4.11.0"
    const val supportLibrary: String = "1.2.0"
    const val material: String = "1.3.0"
    const val constraintLayout: String = "2.1.0-beta02"
    const val room: String = "2.3.0"
    const val rcv = "1.2.0"
    const val vPager = "1.0.0"
    const val coreKtx = "1.3.2"
    const val fragmentKtx = "1.3.3"
    const val activityKtx = "1.2.2"
    const val lifeCycleKtx = "2.4.0-alpha02"
    const val log = "4.7.1"
    const val hilt = "2.35"
    const val hiltWorkManager = "1.0.0"
    const val kotlinSerialization = "1.2.1"
    const val nav = "2.4.0-alpha01"
    const val photoView = "2.0.0"
}

object Libs {
    object Android {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.supportLibrary}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.rcv}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val viewPager = "androidx.viewpager2:viewpager2:${Versions.vPager}"
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
        const val activity = "androidx.activity:activity-ktx:${Versions.activityKtx}"
        const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleKtx}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleKtx}"
        const val lifeCycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifeCycleKtx}"
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
        const val navUI = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    }

    object Kotlin {
        const val std = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    }

    object Injection {
        const val core = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val workManager = "androidx.hilt:hilt-work:${Versions.hiltWorkManager}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltWorkManager}"
    }

    object ImageLoader {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val rcv = "com.github.bumptech.glide:recyclerview-integration:${Versions.glide}"
    }

    object Helper {
        const val log = "com.jakewharton.timber:timber:${Versions.log}"
        const val parser =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
        const val photoView = "com.github.chrisbanes:PhotoView:${Versions.photoView}"
    }

    object Thread {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object Db {
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    }

    object Network {
        const val core = "com.squareup.retrofit2:retrofit:2.9.0"
        const val converter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
        const val log = "com.squareup.okhttp3:logging-interceptor:4.9.0"
    }
}

object Configs {
    const val minSdk = 21
    const val compileSdk = 30
    const val targetSdk = 30

    const val androidApplicationId = "com.umbrella.newsreader"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "android"
    const val kotlinParcel = "kotlin-parcelize"
    const val kapt = "kapt"
    const val serialization = "kotlinx-serialization"
    const val hilt = "dagger.hilt.android.plugin"
    const val safeArgs = "androidx.navigation.safeargs"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav}"
}