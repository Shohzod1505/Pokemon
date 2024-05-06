package ru.itis.kpfu.core.navigation

import javax.inject.Provider

typealias ScreensMap = Map<Class<*>, @JvmSuppressWildcards Provider<Any>>

/**
 * Интерфейс [ScreensMapProvider] определяет метод для предоставления отображения экранов приложения.
 */
interface ScreensMapProvider {

    /**
     * Предоставляет отображение экранов приложения и их поставщиков.
     * @return Отображение экранов и их поставщиков.
     */
    @ScreensQualifier
    fun provideScreensMap(): ScreensMap
}

/**
 * Вспомогательная функция, позволяющая получить экземпляр экрана определенного типа [T] из [ScreensMap].
 * @param T Тип экрана, который требуется получить.
 * @return Экземпляр экрана указанного типа.
 */
inline fun <reified T : ApplicationScreen> ScreensMap.getScreen(): T {
    return (getValue(T::class.java) as Provider<T>).get()
}
