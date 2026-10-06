plugins {
    kotlin("jvm") version "2.3.20"
    application
}

group = "de.phbe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "architecture.MainKt"
}

tasks.test {
    useJUnitPlatform()
}