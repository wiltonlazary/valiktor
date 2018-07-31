import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun DependencyHandler.springBoot(module: String) = "org.springframework.boot:spring-boot-$module:1.5.14.RELEASE"

plugins {
    kotlin("plugin.spring") version "1.2.51"
}

dependencies {
    compileOnly(project(":valiktor-spring:valiktor-spring"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(springBoot("autoconfigure"))
    annotationProcessor(springBoot("autoconfigure-processor"))

    testImplementation(project(":valiktor-spring:valiktor-spring"))
    testImplementation(springBoot("test"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}