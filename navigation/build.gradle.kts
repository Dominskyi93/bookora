plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.compose.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.bookora.navigation"
}

dependencies {
    implementation(projects.features.main.presentation)

    implementation(projects.core.navigationDsl)
    implementation(projects.core.essentials)
    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    //navigation
    implementation(libs.navigation.compose)
    implementation(libs.hilt.navigation)

    implementation(libs.collections.immutable)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}