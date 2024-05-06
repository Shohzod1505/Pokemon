package ru.itis.kpfu.core.common

import android.app.Application

/**
 * Объект [CoreFactory] предоставляет метод для создания экземпляра [CoreProvider].
 * Этот метод использует компонент [CoreComponent] для создания [CoreProvider].
 */
object CoreFactory {

    /**
     * Создает экземпляр [CoreProvider] для указанного приложения.
     * @param app Приложение, для которого создается [CoreProvider].
     * @return Экземпляр [CoreProvider].
     */
    fun createCoreProvider(app: Application): CoreProvider {
        return CoreComponent.create(app)
    }
}
