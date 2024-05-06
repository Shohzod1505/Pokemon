plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-parcelize`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.feature.list.api"
}

dependencies {

    implementation(projects.core.navigation)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.cicerone)
}
