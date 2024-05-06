package ru.itis.kpfu.core.common

import android.app.Application
import dagger.Component
import ru.itis.kpfu.core.common.app.AndroidModule
import ru.itis.kpfu.core.common.resources.ResourcesModule
import javax.inject.Singleton

/**
 * Основной компонент Dagger приложения, обеспечивающий доступ к базовым зависимостям.
 * Реализует интерфейс [CoreProvider].
 */
@Singleton
@Component(
    modules = [
        AndroidModule::class,
        ResourcesModule::class,
    ]
)
interface CoreComponent : CoreProvider {

    /**
     * Внедряет зависимости в указанное приложение.
     * @param application Приложение для внедрения зависимостей.
     */
    fun inject(application: Application)

    companion object {
        /**
         * Создает экземпляр [CoreProvider] для указанного приложения.
         * @param app Приложение, для которого создается [CoreProvider].
         * @return Экземпляр [CoreProvider].
         */
        fun create(app: Application): CoreProvider {
            return DaggerCoreComponent.builder()
                .androidModule(AndroidModule(app))
                .build()
        }
    }
}
