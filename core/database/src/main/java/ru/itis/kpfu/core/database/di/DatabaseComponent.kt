package ru.itis.kpfu.core.database.di

import dagger.Component
import javax.inject.Singleton

/**
 * Компонент Dagger [DatabaseComponent] предоставляет зависимости, связанные с базой данных.
 * Включает модуль [DatabaseModule].
 */
@Singleton
@Component(
    modules = [DatabaseModule::class],
)
interface DatabaseComponent : DatabaseProvider {

    companion object {

        /**
         * Создает экземпляр [DatabaseProvider] с помощью фабричного метода.
         * @return Экземпляр [DatabaseProvider].
         */
        fun init(): DatabaseProvider {
            return DaggerDatabaseComponent.factory()
                .create()
        }
    }

    /**
     * Фабрика компонента [DatabaseComponent].
     */
    @Component.Factory
    interface Factory {

        /**
         * Создает экземпляр [DatabaseProvider] с помощью фабричного метода.
         * @return Экземпляр [DatabaseProvider].
         */
        fun create(): DatabaseProvider
    }

}
