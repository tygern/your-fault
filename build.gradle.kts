plugins {
    kotlin("jvm") version "1.3.10"
    application
}

application.mainClassName = "org.gern.yourfault.YourFaultAppKt"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.eclipse.jetty:jetty-server:9.4.13.v20181111")
    compile("org.eclipse.jetty:jetty-servlet:9.4.13.v20181111")

    compile("javax.servlet:javax.servlet-api:4.0.1")
}

val jar: Jar by tasks

jar.manifest.attributes(mapOf("Main-Class" to application.mainClassName))
jar.from(configurations.compile.get().map { if (it.isDirectory) it else zipTree(it) })
