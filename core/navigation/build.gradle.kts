plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.core.navigation"
}

dependencies {
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.cicerone)
}
