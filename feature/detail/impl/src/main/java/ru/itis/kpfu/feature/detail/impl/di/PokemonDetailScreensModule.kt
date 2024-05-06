package ru.itis.kpfu.feature.detail.impl.di

import dagger.Module
import dagger.Provides
import ru.itis.kpfu.core.navigation.ScreensMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.core.navigation.getScreen
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreen
import ru.itis.kpfu.feature.list.api.PokemonListScreen

@Module
internal class PokemonDetailScreensModule {

    @Provides
    fun providePokemonDetailScreen(
        @ScreensQualifier screensMap: ScreensMap
    ): PokemonDetailScreen {
        return screensMap.getScreen()
    }

    @Provides
    fun providePokemonListScreen(
        @ScreensQualifier screensMap: ScreensMap
    ): PokemonListScreen {
        return screensMap.getScreen()
    }

}
