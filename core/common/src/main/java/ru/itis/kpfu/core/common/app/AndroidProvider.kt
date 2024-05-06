package ru.itis.kpfu.core.common.app

import android.app.Application
import android.content.Context

/**
 * Интерфейс [AndroidProvider] определяет методы для предоставления объектов [Application] и [Context].
 */
interface AndroidProvider {

    /**
     * Предоставляет экземпляр [Application]
     * @return Экземпляр [Application].
     */
    fun provideApplication(): Application

    /**
     * Предоставляет экземпляр [Context]
     * @return Экземпляр [Context].
     */
    fun provideContext(): Context
}
