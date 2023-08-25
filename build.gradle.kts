plugins {
    kotlin("jvm") version "1.9.0"

    id ("me.champeau.jmh") version "0.7.1"
    id ("io.morethan.jmhreport") version "0.9.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.0"

    application
}

group = "br.com.sf"
version = "1.0-SNAPSHOT"

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

jmh {
    resultFormat = "JSON"
    humanOutputFile = project.file("${project.buildDir}/reports/jmh/human.txt") // human-readable output file
    resultsFile = project.file("${project.buildDir}/reports/jmh/results.json") // results file

}

jmhReport {
    jmhResultPath = project.file("build/reports/jmh/results.json").absolutePath
    jmhReportOutput = project.file("build/reports/jmh").absolutePath
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjdk.jmh:jmh-core:0.9")
    implementation("org.openjdk.jmh:jmh-generator-annprocess:0.9")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.jmh {
    finalizedBy("jmhReport")
}

tasks.jmhReport {
    dependsOn("jmh")
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}
