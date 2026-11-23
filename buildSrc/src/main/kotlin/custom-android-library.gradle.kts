plugins {
    id("com.android.library")
}

android {
    compileSdk {
        version = release(Const.TARGET_SDK)
    }

    defaultConfig {
        minSdk = Const.MIN_SDK
        compileSdkMinor = Const.COMPILE_SDK_MINOR

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Const.javaVersion
        targetCompatibility = Const.javaVersion
    }

    setupKotlin()

}