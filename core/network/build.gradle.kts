import java.io.FileInputStream
import java.util.Properties

plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.core.network"

    val keystoreProperties = Properties()
    keystoreProperties.load(FileInputStream(rootProject.file("keys.properties")))

    buildTypes.all {
        buildConfigField("String", "API_ENDPOINT", keystoreProperties["baseUrl"] as String)
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.coroutines)
}
