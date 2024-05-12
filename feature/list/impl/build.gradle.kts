plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-parcelize`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.feature.list.impl"
}

dependencies {
    implementation(projects.feature.list.api)
    implementation(projects.feature.detail.api)
    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(projects.core.network)
    implementation(projects.core.navigation)
    implementation(projects.core.designsystem)

    implementation(libs.bundles.ktx)
    implementation(libs.bundles.ui)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.cicerone)
    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.adapter)
    implementation(libs.glide)
    kapt(libs.glide.compiler)
}
