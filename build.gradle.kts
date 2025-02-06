plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.25"
    id("com.google.devtools.ksp") version "1.9.25-1.0.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.4"
    id("io.micronaut.aot") version "4.4.4"
}

version = "0.1"
group = "com.jeff.cabeleireiro"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    ksp("io.micronaut.data:micronaut-data-processor")
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.microstream:micronaut-microstream-annotations")
    ksp("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.microstream:micronaut-microstream")
    implementation("io.micronaut.microstream:micronaut-microstream-annotations")
    //implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.sql:micronaut-jdbc-tomcat")
    implementation("io.micronaut.flyway:micronaut-flyway")
    runtimeOnly("org.postgresql:postgresql")
    implementation("io.micronaut.validation:micronaut-validation")
    implementation("jakarta.validation:jakarta.validation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.slf4j:slf4j-simple")
    testImplementation("io.micronaut:micronaut-http-client")
    implementation("net.logstash.logback:logstash-logback-encoder:8.0")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    runtimeOnly("org.yaml:snakeyaml")

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

graalvmNative.toolchainDetection = false


micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.jeff.cabeleireiro.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = false


    }
}