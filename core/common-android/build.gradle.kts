plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.custom.compose.library)
}

android {
    namespace = "com.bookora.core.common_android"
}

dependencies {
    api(projects.core.essentials)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.timber)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}