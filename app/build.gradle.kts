plugins {
    alias(libs.plugins.custom.android.application)
    alias(libs.plugins.custom.compose.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.bookora"

    defaultConfig {
        applicationId = "com.bookora"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(projects.core.commonAndroid)

    implementation(projects.templates.androidLibrary)
    implementation(projects.templates.kotlinLibrary)
    implementation(projects.templates.feature.domain)
    implementation(projects.templates.feature.presentation)
    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    //test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}