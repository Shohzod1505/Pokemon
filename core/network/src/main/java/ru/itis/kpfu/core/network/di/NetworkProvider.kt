package ru.itis.kpfu.core.network.di

import ru.itis.kpfu.core.network.domain.PokemonRepository

/**
 * Интерфейс [NetworkProvider], предоставляющий зависимости для работы с сетью.
 */
interface NetworkProvider {

    /**
     * Предоставляет репозиторий для получения данных о покемонах.
     * @return Репозиторий [PokemonRepository] для работы с данными о покемонах.
     */
    fun providePokemonRepository(): PokemonRepository
}
