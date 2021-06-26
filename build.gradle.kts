plugins {
    kotlin("js") version "1.5.10"
}

group = "me.sergeigrishchenko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.213-kotlin-1.5.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.213-kotlin-1.5.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.5.0")
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser()
    }
}