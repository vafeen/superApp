pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SuperApp"
include(":app")
include(":core:common")
include(":core:impl")
include(":feature:test_screen:api")
include(":feature:test_screen:impl")
include(":feature:services_screen:api")
include(":feature:services_screen:impl")
include(":core:flowers")
include(":core:flowers-impl")
include(":feature:flowers_screen")
