package ru.itis.kpfu.feature.list.api

import com.github.terrakok.cicerone.Screen
import ru.itis.kpfu.core.navigation.ApplicationScreen

/**
 * Интерфейс [PokemonListScreen] определяет контракт для экрана список покемонов в приложении.
 * Расширяет интерфейс [ApplicationScreen].
 */
interface PokemonListScreen: ApplicationScreen {

    /**
     * Оператор вызова, который создает экран [PokemonListScreen] на основе модели [PokemonListScreenModel].
     * @param model Модель [PokemonListScreenModel], представляющая данные экрана.
     * @return Объект [Screen], представляющий экран [PokemonListScreen].
     */
    operator fun invoke(model: PokemonListScreenModel): Screen
}
