package ru.itis.kpfu.core.common

import ru.itis.kpfu.core.common.app.AndroidProvider
import ru.itis.kpfu.core.common.resources.Resources

/**
 * Интерфейс [CoreProvider] определяет метод для предоставления основных зависимостей приложения и унаследован от [AndroidProvider].
 */
interface CoreProvider : AndroidProvider {

    /**
     * Предоставляет экземпляр [Resources] для доступа к ресурсам приложения.
     * @return Экземпляр [Resources].
     */
    fun provideResources(): Resources
}
