plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

apply<MainGradlePlugin>()

android {
    namespace = "ru.itis.kpfu.core.database"
}

dependencies {
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.bundles.room)
    kapt(libs.room.compiler)
    implementation(libs.bundles.coroutines)
}
