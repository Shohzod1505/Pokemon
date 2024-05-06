package ru.itis.kpfu.core.navigation

import dagger.Component
import javax.inject.Singleton

/**
 * Компонент Dagger для управления навигацией в приложении.
 * Реализует интерфейс [NavigationProvider].
 */
@Singleton
@Component(
    modules = [NavigationModule::class],
)
interface NavigationComponent : NavigationProvider {

    companion object {

        /**
         * Предоставляет метод [init], который инициализирует и возвращает экземпляр [NavigationProvider].
         */
        fun init(): NavigationProvider {
            return DaggerNavigationComponent.factory()
                .create()
        }
    }

    /**
     * Фабричный интерфейс для создания [NavigationProvider].
     */
    @Component.Factory
    interface Factory {
        /**
         * Создает экземпляр [NavigationProvider].
         */
        fun create(): NavigationProvider
    }

}
