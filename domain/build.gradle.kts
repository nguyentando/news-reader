plugins {
    id(Plugins.androidLibrary)
    id(Plugins.hilt)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kapt)
}

android {
    compileSdkVersion(Configs.compileSdk)

    defaultConfig {
        minSdkVersion(Configs.minSdk)
        targetSdkVersion(Configs.targetSdk)
        versionCode = 1
        versionName = "1.0"
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
    api(project(":data"))

    // kotlin
    implementation(Libs.Kotlin.std)

    // helper
    implementation(Libs.Helper.log)

    // thread
    implementation(Libs.Thread.core)

    // dagger
    implementation(Libs.Injection.core)
    kapt(Libs.Injection.daggerCompiler)
}