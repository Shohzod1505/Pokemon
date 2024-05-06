package ru.itis.kpfu.core.network.di

import dagger.Component
import javax.inject.Singleton

/**
 * Компонент Dagger [NetworkComponent] предоставляет зависимости, связанные с сетью.
 * Включает модуль [NetworkModule].
 */
@Singleton
@Component(
    modules = [NetworkModule::class],
)
interface NetworkComponent : NetworkProvider {

    companion object {

        /**
         * Создает экземпляр [NetworkProvider] с помощью фабричного метода.
         * @return Экземпляр [NetworkProvider].
         */
        fun init(): NetworkProvider {
            return DaggerNetworkComponent.factory()
                .create()
        }
    }

    /**
     * Фабрика компонента [NetworkComponent].
     */
    @Component.Factory
    interface Factory {

        /**
         * Создает экземпляр [NetworkProvider] с помощью фабричного метода.
         * @return Экземпляр [NetworkProvider].
         */
        fun create(): NetworkProvider
    }

}
