plugins {
    id(Plugins.androidApplication)
    id(Plugins.hilt)
    kotlin(Plugins.kotlinAndroid)
    id(Plugins.kotlinParcel)
    kotlin(Plugins.kapt)
    id(Plugins.safeArgs)
}

android {
    compileSdkVersion(Configs.compileSdk)

    defaultConfig {
        applicationId = Configs.androidApplicationId
        minSdkVersion(Configs.minSdk)
        targetSdkVersion(Configs.targetSdk)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))

    // kotlin
    implementation(Libs.Kotlin.std)

    // android
    implementation(Libs.Android.appCompat)
    implementation(Libs.Android.material)
    implementation(Libs.Android.recyclerView)
    implementation(Libs.Android.constraint)
    implementation(Libs.Android.viewPager)
    implementation(Libs.Android.core)
    implementation(Libs.Android.fragment)
    implementation(Libs.Android.activity)
    implementation(Libs.Android.lifeCycle)
    implementation(Libs.Android.viewModel)
    implementation(Libs.Android.lifeCycleCommon)
    implementation(Libs.Android.navFragment)
    implementation(Libs.Android.navUI)

    // dagger
    implementation(Libs.Injection.core)
    kapt(Libs.Injection.daggerCompiler)
    kapt(Libs.Injection.hiltCompiler)

    // load image
    implementation(Libs.ImageLoader.core)
    kapt(Libs.ImageLoader.compiler)
    implementation(Libs.ImageLoader.rcv) {
        isTransitive = false
    }

    // helper
    implementation(Libs.Helper.log)

    // thread
    implementation(Libs.Thread.core)
    implementation(Libs.Thread.android)
}