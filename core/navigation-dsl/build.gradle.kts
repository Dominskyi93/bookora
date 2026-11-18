plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.compose.library)
}

android {
    namespace = "com.bookora.templates.android_library"
}

dependencies {
    implementation(libs.collections.immutable)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}