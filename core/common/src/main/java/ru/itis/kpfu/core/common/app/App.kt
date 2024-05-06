package ru.itis.kpfu.core.common.app

/**
 * Интерфейс [App] определяет метод для получения поставщика приложения [ApplicationProvider].
 */
interface App {

    /**
     * Получает поставщика приложения [ApplicationProvider].
     * @return Поставщик приложения [ApplicationProvider].
     */
    fun getApplicationProvider(): ApplicationProvider
}
