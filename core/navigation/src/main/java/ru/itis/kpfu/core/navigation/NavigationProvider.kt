package ru.itis.kpfu.core.navigation

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

/**
 * Интерфейс [NavigationProvider] определяет методы для предоставления экземпляров
 * [Router] и [NavigatorHolder], необходимых для управления навигацией в приложении.
 */
interface NavigationProvider {

    /**
     * Предоставляет экземпляр [Router] для управления навигацией в приложении.
     * @return Экземпляр [Router].
     */
    fun provideRouter(): Router

    /**
     * Предоставляет экземпляр [NavigatorHolder] для управления навигатором в приложении.
     * @return Экземпляр [NavigatorHolder].
     */
    fun provideNavigatorHolder(): NavigatorHolder
}
