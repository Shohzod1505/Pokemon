package ru.itis.kpfu.core.network.domain

import ru.itis.kpfu.core.network.data.response.PokemonListResponse
import ru.itis.kpfu.core.network.data.response.PokemonResponse

/**
 * Интерфейс [PokemonRepository] для получения данных о покемонах.
 */
interface PokemonRepository {

    /**
     * Получает данные о покемонах на основе предоставленного запроса.
     * @param name Поисковый запрос для фильтрации данных о покемонах.
     * @return Объект [PokemonResponse], содержащий данные ответа.
     */
    suspend fun getPokemon(name: String?): PokemonResponse

    /**
     * Получает список покемонов на основе предоставленного запроса.
     * @param limit Поисковый запрос для фильтрации количества покемонов.
     * @return Объект [PokemonListResponse], содержащий данные ответа.
     */
    suspend fun getPokemonList(limit: Int): PokemonListResponse
}
