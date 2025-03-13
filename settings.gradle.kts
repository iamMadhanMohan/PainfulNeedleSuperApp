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

rootProject.name = "Adam Super App"
include(":app")
include(":core")
include(":feature-learn")
include(":feature-handyman")
include(":feature-mechanic")
include(":feature-pcrepair")
include(":feature-laundry")
include(":feature-housecleaning")
include(":test-feature")
