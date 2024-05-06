import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.detektApplication)
}

detekt {
    source.setFrom(files(projectDir))
    config.setFrom(files("${project.rootDir}/config/detekt/detekt.yml"))
    parallel = true
}

tasks.withType<Detekt>().configureEach {
    reports {
        txt.required.set(false)
        xml.required.set(false)
        sarif.required.set(false)
        html {
            required.set(true)
            outputLocation.set(file("app/build/reports/detekt/detekt.html"))
        }
    }
}
