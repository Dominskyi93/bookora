import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("org.jetbrains.kotlin.plugin.compose")
}

val customLibs = the<LibrariesForLibs>()

dependencies {
    add("implementation", platform(customLibs.androidx.compose.bom))
    add("implementation", customLibs.androidx.activity.compose)
    add("implementation", customLibs.androidx.compose.ui)
    add("implementation", customLibs.androidx.compose.ui.graphics)
    add("implementation", customLibs.androidx.compose.ui.tooling.preview)
    add("implementation", customLibs.androidx.compose.material3)
    add("implementation", customLibs.androidx.compose.material3.adaptive.navigation.suite)
    add("implementation", customLibs.androidx.material.icons.extended)

    add("debugImplementation", customLibs.androidx.compose.ui.tooling)
    add("debugImplementation", customLibs.androidx.compose.ui.test.manifest)
}