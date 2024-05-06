plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.core.common"
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.network)
    implementation(projects.core.navigation)
    implementation(projects.core.designsystem)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.bundles.ktx)
    implementation(libs.bundles.ui)

}
