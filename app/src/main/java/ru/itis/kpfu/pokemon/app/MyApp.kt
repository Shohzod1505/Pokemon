package ru.itis.kpfu.pokemon.app

import android.app.Application
import ru.itis.kpfu.core.common.app.App
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.pokemon.di.ApplicationComponent

/**
 * Класс [MyApp] является основным классом приложения.
 * Реализует интерфейс [App] для предоставления поставщика приложения [ApplicationProvider].
 */
class MyApp: Application(), App {

    private lateinit var appComponent: ApplicationProvider

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.init(this)
    }

    override fun getApplicationProvider(): ApplicationProvider {
        return appComponent
    }

}
