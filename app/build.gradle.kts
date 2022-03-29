plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.Android.android_core)
    implementation(Dependencies.Android.android_appcompat)
    implementation(Dependencies.Android.android_material)
    implementation(Dependencies.Android.android_runtime)
    implementation(Dependencies.Android.android_compose)

    // Testing
    testImplementation(Dependencies.Android.android_test_junit)
    androidTestImplementation(Dependencies.Android.android_androidTest_junit)
    androidTestImplementation(Dependencies.Android.android_androidTest_espresso)
    androidTestImplementation(Dependencies.Compose.compose_ui_test_junit4)
    debugImplementation(Dependencies.Compose.compose_ui_tooling)

    // Compose dependencies
    implementation(Dependencies.Compose.compose_ui)
    implementation(Dependencies.Compose.compose_material)
    implementation(Dependencies.Compose.compose_ui_tooling_preview)
    implementation(Dependencies.Compose.compose_viewmodel)
    implementation(Dependencies.Compose.compose_navigation)
    implementation(Dependencies.Compose.compose_accompanist)


    // Coroutines
    implementation(Dependencies.Coroutines.coroutines_core)
    implementation(Dependencies.Coroutines.coroutines_android)

    // Coroutine Lifecycle Scopes
    implementation(Dependencies.Coroutines.coroutines_viewmodel)
    implementation(Dependencies.Coroutines.coroutines_runtime)

    //Dagger - Hilt
    implementation(Dependencies.Hilt.hilt_android)
    implementation(Dependencies.Hilt.hilt_lifecycle_viewmodel)
    implementation(Dependencies.Hilt.hilt_navigation_compose)
    kapt(Dependencies.Hilt.hilt_android_compiler)
    kapt(Dependencies.Hilt.hilt_compiler)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit_retrofit)
    implementation(Dependencies.Retrofit.retrofit_converter_gson)
    implementation(Dependencies.Retrofit.retrofit_okhttp)
    implementation(Dependencies.Retrofit.retrofit_logging_interceptor)

    // Room
    implementation(Dependencies.Room.room_runtime)
    implementation(Dependencies.Room.room_ktx)
    kapt(Dependencies.Room.room_compiler)
}