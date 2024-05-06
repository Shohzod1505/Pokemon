package ru.itis.kpfu.pokemon.di

import dagger.Component
import ru.itis.kpfu.core.common.CoreFactory
import ru.itis.kpfu.core.common.CoreProvider
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.viewmodel.ViewModelFactoryModule
import ru.itis.kpfu.core.database.di.DatabaseComponent
import ru.itis.kpfu.core.database.di.DatabaseProvider
import ru.itis.kpfu.core.navigation.NavigationComponent
import ru.itis.kpfu.core.navigation.NavigationProvider
import ru.itis.kpfu.core.network.di.NetworkComponent
import ru.itis.kpfu.core.network.di.NetworkProvider
import ru.itis.kpfu.pokemon.app.MyApp
import javax.inject.Singleton

/**
 * Компонент Dagger [ApplicationComponent] представляет основной компонент приложения.
 * Включает зависимости [CoreProvider], [NavigationProvider], [DatabaseProvider] и [NetworkProvider],
 * а также модули [ViewModelFactoryModule] и [ScreensBinding].
 */
@Singleton
@Component(
    dependencies = [
        CoreProvider::class,
        NavigationProvider::class,
        DatabaseProvider::class,
        NetworkProvider::class,
    ],
    modules = [
        ViewModelFactoryModule::class,
        ScreensBinding::class,
    ]
)
interface ApplicationComponent : ApplicationProvider {

    companion object {

        /**
         * Создает экземпляр [ApplicationProvider] с помощью фабричного метода.
         * @param app Экземпляр приложения [MyApp].
         * @return Экземпляр [ApplicationProvider].
         */
        fun init(app: MyApp): ApplicationProvider {
            val androidProvider = CoreFactory.createCoreProvider(app)
            return DaggerApplicationComponent.factory()
                .create(
                    coreProvider = androidProvider,
                    navigationProvider = NavigationComponent.init(),
                    databaseProvider = DatabaseComponent.init(),
                    networkProvider = NetworkComponent.init(),
                )
        }
    }

    /**
     * Фабрика компонента [ApplicationComponent].
     */
    @Component.Factory
    interface Factory {

        /**
         * Создает экземпляр [ApplicationComponent] с помощью фабричного метода.
         * @param coreProvider Поставщик ядра [CoreProvider].
         * @param navigationProvider Поставщик навигации [NavigationProvider].
         * @param databaseProvider Поставщик базы данных [DatabaseProvider].
         * @param databaseProvider Поставщик сети данных [NetworkProvider].
         * @return Экземпляр [ApplicationComponent].
         */
        fun create(
            coreProvider: CoreProvider,
            navigationProvider: NavigationProvider,
            databaseProvider: DatabaseProvider,
            networkProvider: NetworkProvider,
        ): ApplicationComponent
    }

    /**
     * Внедряет зависимости в [MyApp].
     * @param app Экземпляр [MyApp].
     */
    fun inject(app: MyApp)
}
