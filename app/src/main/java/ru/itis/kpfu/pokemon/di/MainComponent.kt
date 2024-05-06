package ru.itis.kpfu.pokemon.di

import dagger.Component
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.pokemon.presentation.MainActivity
import javax.inject.Singleton

/**
 * Компонент Dagger [MainComponent] представляет основной компонент приложения.
 * Включает зависимости [ApplicationProvider] и модули [ScreensBinding] и [MainViewModelModule].
 */
@Singleton
@Component(
    dependencies = [
        ApplicationProvider::class,
    ],
    modules = [
        ScreensBinding::class,
        MainViewModelModule::class,
    ]
)
internal interface MainComponent {

    companion object {

        /**
         * Создает экземпляр [MainComponent] с помощью фабричного метода.
         * @param applicationProvider Поставщик приложения [ApplicationProvider].
         * @return Экземпляр [MainComponent].
         */
        fun init(
            applicationProvider: ApplicationProvider
        ): MainComponent {
            return DaggerMainComponent.factory()
                .create(applicationProvider)
        }
    }

    /**
     * Фабрика компонента [MainComponent].
     */
    @Component.Factory
    interface Factory {

        /**
         * Создает экземпляр [MainComponent] с помощью фабричного метода.
         * @param applicationProvider Поставщик приложения [ApplicationProvider].
         * @return Экземпляр [MainComponent].
         */
        fun create(
            applicationProvider: ApplicationProvider
        ): MainComponent
    }

    /**
     * Внедряет зависимости в [MainActivity].
     * @param mainActivity Экземпляр [MainActivity].
     */
    fun inject(mainActivity: MainActivity)
}
