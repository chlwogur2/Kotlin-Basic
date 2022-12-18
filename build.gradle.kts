import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Kotlin DSL
 * 1. 모든 문자열에 "큰 따옴표" 사용해야 한다.
 * 2. 괄호가 필수적이다.
 * 3. 등호(=)를 사용하여 값을 할당한다.
 */

plugins {
    kotlin("jvm") version "1.6.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}