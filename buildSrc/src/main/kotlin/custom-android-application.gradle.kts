plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    compileSdk {
        version = release(Const.TARGET_SDK)
    }

    defaultConfig {
        minSdk = Const.MIN_SDK
        targetSdk = Const.TARGET_SDK
        compileSdkMinor = Const.COMPILE_SDK_MINOR

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = Const.javaVersion
        targetCompatibility = Const.javaVersion
    }
    buildFeatures {
        compose = true
    }
}