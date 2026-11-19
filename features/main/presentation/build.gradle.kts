plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.compose.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.bookora.features.main.presentation"
}

dependencies {
    api(projects.features.main.domain)
    implementation(projects.core.essentials)
//    implementation(projects.core.presentation)
//    implementation(projects.core.theme)
    implementation(projects.core.navigationDsl)
    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.collections.immutable)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}