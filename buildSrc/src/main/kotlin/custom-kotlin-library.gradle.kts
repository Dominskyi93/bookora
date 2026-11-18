plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = Const.javaVersion
    targetCompatibility = Const.javaVersion
}

setupKotlin()