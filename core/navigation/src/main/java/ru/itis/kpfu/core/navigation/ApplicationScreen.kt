package ru.itis.kpfu.core.navigation

/**
 * Интерфейс [ApplicationScreen] представляет экран внутри приложения.
 * Этот интерфейс определяет свойство [screenKey], которое является строковым идентификатором
 * для данного экрана. По умолчанию [screenKey] устанавливается как имя класса экрана.
 */
interface ApplicationScreen {
    val screenKey: String get() = this::class.java.name
}
