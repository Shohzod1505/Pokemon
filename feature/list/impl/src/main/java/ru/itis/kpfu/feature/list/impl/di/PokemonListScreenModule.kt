package ru.itis.kpfu.feature.list.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.feature.list.api.PokemonListScreen
import ru.itis.kpfu.feature.list.impl.api.PokemonListScreenImpl

/**
 * Dagger-модуль для связывания зависимостей, связанных с экраном [PokemonListScreen].
 */
@Module
interface PokemonListScreenModule {

    /**
     * Связывает реализацию [PokemonListScreenImpl] с интерфейсом [PokemonListScreen].
     * @param screen Реализация интерфейса [PokemonListScreenImpl].
     * @return Объект типа [PokemonListScreen].
     */
    @Binds
    fun bindPokemonListScreen(screen: PokemonListScreenImpl): PokemonListScreen

    /**
     * Добавляет экземпляр [PokemonListScreen] в карту экранов приложения.
     * @param screen Экземпляр [PokemonListScreen].
     * @return Объект типа [Any].
     */
    @Binds
    @IntoMap
    @ScreensQualifier
    @ClassKey(PokemonListScreen::class)
    fun bindPokemonListScreenToMap(screen: PokemonListScreen): Any
}
