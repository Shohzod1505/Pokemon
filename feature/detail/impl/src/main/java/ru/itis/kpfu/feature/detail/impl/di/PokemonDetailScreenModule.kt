package ru.itis.kpfu.feature.detail.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreen
import ru.itis.kpfu.feature.detail.impl.api.PokemonDetailScreenImpl

/**
 * Dagger-модуль для связывания зависимостей, связанных с экраном [PokemonDetailScreen].
 */
@Module
interface PokemonDetailScreenModule {

    /**
     * Связывает реализацию [PokemonDetailScreenImpl] с интерфейсом [PokemonDetailScreen].
     * @param screen Реализация интерфейса [PokemonDetailScreenImpl].
     * @return Объект типа [PokemonDetailScreen].
     */
    @Binds
    fun bindPokemonDetailScreen(screen: PokemonDetailScreenImpl): PokemonDetailScreen

    /**
     * Добавляет экземпляр [PokemonDetailScreen] в карту экранов приложения.
     * @param screen Экземпляр [PokemonDetailScreen].
     * @return Объект типа [Any].
     */
    @Binds
    @IntoMap
    @ScreensQualifier
    @ClassKey(PokemonDetailScreen::class)
    fun bindPokemonDetailScreenToMap(screen: PokemonDetailScreen): Any
}
