object Dependencies {

    object Android {
        const val android_core_version = "1.7.0"
        const val android_appcompat_version = "1.4.1"
        const val android_material_version = "1.5.0"
        const val android_runtime_version = "2.4.1"
        const val android_compose_version = "1.4.0"

        const val android_test_junit_version = "4.+"
        const val android_androidTest_junit_version = "1.1.3"
        const val android_espresso_version = "3.4.0"

        const val android_core = "androidx.core:core-ktx:$android_core_version"
        const val android_appcompat = "androidx.appcompat:appcompat:$android_appcompat_version"
        const val android_material = "com.google.android.material:material:$android_material_version"
        const val android_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$android_runtime_version"
        const val android_compose = "androidx.activity:activity-compose:$android_compose_version"

        const val android_test_junit = "junit:junit:$android_test_junit_version"
        const val android_androidTest_junit = "androidx.test.ext:junit:$android_androidTest_junit_version"
        const val android_androidTest_espresso = "androidx.test.espresso:espresso-core:$android_espresso_version"
    }

    object Compose {
        const val compose_version = "1.0.1"
        const val compose_viewmodel_version = "1.0.0-alpha07"
        const val compose_navigation_version = "2.4.0-alpha08"
        const val compose_accompanist_version = "0.17.0"

        const val compose_ui = "androidx.compose.ui:ui:$compose_version"
        const val compose_material = "androidx.compose.material:material:$compose_version"
        const val compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:$compose_version"

        const val compose_ui_test_junit4 = "androidx.compose.ui:ui-test-junit4:$compose_version"
        const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:$compose_version"

        const val compose_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:$compose_viewmodel_version"
        const val compose_navigation = "androidx.navigation:navigation-compose:$compose_navigation_version"
        const val compose_accompanist = "com.google.accompanist:accompanist-flowlayout:$compose_accompanist_version"
    }

    object Hilt {
        const val hilt_version = "2.38.1"
        const val hilt_ui_version = "1.0.0-alpha03"
        const val hilt_compiler_version = "1.0.0"
        const val hilt_android_compiler_version = "2.37"

        const val hilt_android = "com.google.dagger:hilt-android:$hilt_version"
        const val hilt_lifecycle_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$hilt_ui_version"
        const val hilt_navigation_compose = "androidx.hilt:hilt-navigation-compose:$hilt_ui_version"
        const val hilt_compiler = "androidx.hilt:hilt-compiler:$hilt_compiler_version"
        const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:$hilt_android_compiler_version"
    }

    object Retrofit {
        const val retrofit_version = "2.9.0"
        const val retrofit_gson_version = "2.9.0"
        const val retrofit_okhttp_version = "5.0.0-alpha.2"

        const val retrofit_retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
        const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:$retrofit_gson_version"
        const val retrofit_okhttp = "com.squareup.okhttp3:okhttp:$retrofit_okhttp_version"
        const val retrofit_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:$retrofit_okhttp_version"
    }

    object Room {
        const val room_version = "2.4.2"

        const val room_runtime = "androidx.room:room-runtime:$room_version"
        const val room_compiler = "androidx.room:room-compiler:$room_version"
        const val room_ktx = "androidx.room:room-ktx:$room_version"
    }

    object Coroutines {
        const val coroutines_version = "1.5.2"
        const val coroutines_lifecycle_version = "2.3.1"

        const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
        const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"

        const val coroutines_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$coroutines_lifecycle_version"
        const val coroutines_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$coroutines_lifecycle_version"
    }

    object Plugins {
        const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.3"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21"
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.38.1"
    }

}