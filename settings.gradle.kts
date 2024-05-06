enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")


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

rootProject.name = "Pokemon"
include(":app")
include(":core:common")
include(":core:navigation")
include(":core:database")
include(":core:network")
include(":core:designsystem")
include(":feature:detail:api")
include(":feature:detail:impl")
include(":feature:list:api")
include(":feature:list:impl")
