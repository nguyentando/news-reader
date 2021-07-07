plugins {
    id(Plugins.androidLibrary)
    id(Plugins.serialization)
    id(Plugins.hilt)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kapt)
    id(Plugins.kotlinParcel)
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
    // android
    implementation(Libs.Android.core)

    // kotlin
    implementation(Libs.Kotlin.std)

    // helper
    implementation(Libs.Helper.log)
    api(Libs.Helper.parser)

    // thread
    implementation(Libs.Thread.core)

    // db, support for apple m1
    api(Libs.Db.room) {
        exclude(group = "org.xerial")
    }
    kapt(Libs.Db.roomCompiler) {
        exclude(group = "org.xerial")
    }
    api(Libs.Db.roomKtx) {
        exclude(group = "org.xerial")
    }
    api("org.xerial:sqlite-jdbc:3.34.0")

    // network
    api(Libs.Network.core)
    api(Libs.Network.converter)
    api(Libs.Network.log)

    // dagger
    implementation(Libs.Injection.core)
    kapt(Libs.Injection.daggerCompiler)
}