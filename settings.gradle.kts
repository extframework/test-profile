pluginManagement {
    repositories {
        maven {
            url = uri("https://maven.extframework.dev/snapshots")
        }
        maven {
            url = uri("https://maven.extframework.dev/releases")
        }
        gradlePluginPortal()
    }
}
rootProject.name = "test-profile"

