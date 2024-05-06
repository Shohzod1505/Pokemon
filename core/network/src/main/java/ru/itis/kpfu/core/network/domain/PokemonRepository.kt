package ru.itis.kpfu.core.network.domain

import ru.itis.kpfu.core.network.data.response.PokemonResponse

/**
 * Интерфейс [PokemonRepository] для получения данных о покемонах.
 */
interface PokemonRepository {

    /**
     * Получает данные о покемонах на основе предоставленного запроса.
     * @param query Поисковый запрос для фильтрации данных о покемонах. Может быть null, чтобы получить всех покемонов.
     * @return Объект [PokemonResponse], содержащий данные ответа.
     */
    suspend fun getPokemon(query: String?): PokemonResponse
}
