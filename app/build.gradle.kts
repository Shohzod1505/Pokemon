plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("kotlin-parcelize")
}

android {
    namespace = ProjectConfig.applicationId
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.applicationId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(projects.core.navigation)
    implementation(projects.core.designsystem)
    implementation(projects.core.network)
    implementation(projects.feature.list.api)
    implementation(projects.feature.list.impl)
    implementation(projects.feature.detail.api)
    implementation(projects.feature.detail.impl)

    implementation(libs.bundles.ktx)
    implementation(libs.bundles.ui)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.bundles.room)
    kapt(libs.room.compiler)
    implementation(libs.bundles.retrofit)
    implementation(libs.cicerone)
    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.test)
}
