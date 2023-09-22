plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
    id("org.jetbrains.kotlin.kapt") version "1.8.22"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.8.22"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.8.22"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.7.9"
    id("io.micronaut.test-resources") version "3.7.9"
}

version = "0.1"
group = "com.jeff.cabeleireiro"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut.data:micronaut-data-processor")
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.microstream:micronaut-microstream-annotations")
    kapt("io.micronaut.serde:micronaut-serde-processor")
    kaptTest("io.micronaut:micronaut-inject-java")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.microstream:micronaut-microstream")
    implementation("io.micronaut.microstream:micronaut-microstream-annotations")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.sql:micronaut-hibernate-jpa")
    implementation("io.micronaut.sql:micronaut-jdbc-tomcat")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("net.logstash.logback:logstash-logback-encoder:7.4")
    implementation("ch.qos.logback:logback-classic:1.4.11")



    testImplementation("org.slf4j:slf4j-simple:2.0.7")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("org.postgresql:postgresql")
    developmentOnly("io.micronaut.microstream:micronaut-microstream-rest")
    testImplementation("io.mockk:mockk:1.13.5")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.micronaut.test:micronaut-test-kotest5:3.9.2")
    testImplementation("io.mockk:mockk:{mockkVersion}")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:{kotestVersion}")
    runtimeOnly("org.bouncycastle:bcprov-jdk18on:1.71")
    runtimeOnly("org.bouncycastle:bcpkix-jdk18on:1.71")
}

application {
    mainClass.set("com.jeff.cabeleireiro.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}


graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.jeff.cabeleireiro.*")
    }
}



