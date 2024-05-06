package ru.itis.kpfu.feature.detail.api

import com.github.terrakok.cicerone.Screen
import ru.itis.kpfu.core.navigation.ApplicationScreen

/**
 * Интерфейс [PokemonDetailScreen] определяет контракт для экрана информации о покемоне в приложении.
 * Расширяет интерфейс [ApplicationScreen].
 */
interface PokemonDetailScreen: ApplicationScreen {

    /**
     * Оператор вызова, который создает экран [PokemonDetailScreen] на основе модели [PokemonDetailScreenModel].
     * @param model Модель [PokemonDetailScreenModel], представляющая данные экрана.
     * @return Объект [Screen], представляющий экран [PokemonDetailScreen].
     */
    operator fun invoke(model: PokemonDetailScreenModel): Screen
}
