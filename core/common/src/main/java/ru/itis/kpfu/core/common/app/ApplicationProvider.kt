package ru.itis.kpfu.core.common.app

import ru.itis.kpfu.core.common.CoreProvider
import ru.itis.kpfu.core.database.di.DatabaseProvider
import ru.itis.kpfu.core.navigation.NavigationProvider
import ru.itis.kpfu.core.navigation.ScreensMapProvider
import ru.itis.kpfu.core.network.di.NetworkProvider

/**
 * Интерфейс [ApplicationProvider] объединяет другие интерфейсы, предоставляющие различные зависимости для приложения.
 * Включает в себя [CoreProvider], [NavigationProvider], [DatabaseProvider], [NetworkProvider] и [ScreensMapProvider].
 */
interface ApplicationProvider :
    CoreProvider,
    NavigationProvider,
    DatabaseProvider,
    NetworkProvider,
    ScreensMapProvider
