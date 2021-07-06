object Versions {
    const val kotlin = "1.5.10"
    const val coroutines = "1.5.0"
    const val gradlePlugin: String = "4.0.2"
    const val glide: String = "4.11.0"
    const val glideTransform: String = "4.0.0"
    const val supportLibrary: String = "1.2.0"
    const val material: String = "1.3.0"
    const val constraintLayout: String = "2.1.0-beta02"
    const val room: String = "2.3.0"
    const val rcv = "1.2.0"
    const val vPager = "1.0.0"
    const val coreKtx = "1.3.2"
    const val fragmentKtx = "1.3.3"
    const val activityKtx = "1.2.2"
    const val lifeCycleKtx = "2.4.0-alpha01"
    const val log = "4.7.1"
    const val hilt = "2.35"
    const val hiltWorkManager = "1.0.0"
    const val viewBindingHelper = "1.3.1"
    const val fps = "2.1.0"
    const val kotlinSerialization = "1.2.1"
    const val workManager = "2.7.0-alpha04"
    const val testExtJunit = "1.1.0"
    const val coreTestingVersion = "2.0.0"
    const val espressoVersion = "3.1.1"
    const val truth = "1.1.2"
    const val mockKotlin = "2.2.0"
    const val firebase = "26.5.0"
    const val mockito = "2.22.0"
    const val graph = "v3.1.0"
    const val leak = "2.7"
    const val crypto = "1.0.0"
    const val androidXTest = "1.4.0"
}

object Libs {
    object Android {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.supportLibrary}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.rcv}"
        const val constraint =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val viewPager = "androidx.viewpager2:viewpager2:${Versions.vPager}"
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
        const val activity = "androidx.activity:activity-ktx:${Versions.activityKtx}"
        const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleKtx}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycleKtx}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleKtx}"
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
    }

    object Helper {
        const val log = "com.jakewharton.timber:timber:${Versions.log}"
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

    object Test {
        const val core = "junit:junit:4.12"
        const val androidXTestCore = "androidx.test:core:${Versions.androidXTest}"
        const val androidXTestRules = "androidx.test:rules:${Versions.androidXTest}"
        const val androidXTestRunner = "androidx.test:runner:${Versions.androidXTest}"
        const val robolectric = "androidx.test:core:1.0.0"
        const val mockito = "org.mockito:mockito-core:${Versions.mockito}"

        const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockito}"
        const val mockKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockKotlin}"
        const val room = "androidx.room:room-testing:${Versions.room}"
        const val hilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val hilt2 = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
        const val archCore = "androidx.arch.core:core-testing:${Versions.coreTestingVersion}"
        const val espresso1 = "androidx.test.espresso:espresso-contrib:${Versions.espressoVersion}"
        const val espresso2 = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val espresso3 = "androidx.test.espresso:espresso-intents:${Versions.espressoVersion}"
        const val truth = "com.google.truth:truth:${Versions.truth}"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        const val workManager = "androidx.work:work-testing:${Versions.workManager}"
    }

    object Firebase {
        const val core = "com.google.firebase:firebase-bom:${Versions.firebase}"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val crash = "com.google.firebase:firebase-crashlytics-ktx"
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
    const val googleService = "com.google.gms.google-services"
    const val crash = "com.google.firebase.crashlytics"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val googleService = "com.google.gms:google-services:4.3.5"
    const val crash = "com.google.firebase:firebase-crashlytics-gradle:2.2.0"
}