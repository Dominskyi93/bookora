pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Bookora"
include(":app")
include(":core:essentials")
include(":core:common-android")
include(":core:navigation-dsl")
include(":navigation")

include(":features:main:domain")
include(":features:main:presentation")
include(":features:profile:domain")
include(":features:profile:presentation")
include(":features:library:domain")
include(":features:library:presentation")

include(":templates:android-library")
include(":templates:kotlin-library")
include(":templates:feature:domain")
include(":templates:feature:presentation")
