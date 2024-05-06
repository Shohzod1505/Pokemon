plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.core.designsystem"
}

dependencies {
    implementation(libs.bundles.ktx)
    implementation(libs.bundles.ui)
}
