import dev.extframework.gradle.common.RepositoryType
import dev.extframework.gradle.common.extFramework

plugins {
    id("java")
    id("dev.extframework.common") version "1.0.31"
    `maven-publish`
}

group = "dev.extframework"
version = "1.0.4"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

common {
    publishing {
        publication {
            withJava()
        }

        repositories {
            extFramework(credentials = propertyCredentialProvider, type=RepositoryType.RELEASES)
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

tasks.test {
    useJUnitPlatform()
}
