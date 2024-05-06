package ru.itis.kpfu.core.database.domain

import ru.itis.kpfu.core.database.data.entity.PokemonEntity

/**
 * Интерфейс [PokemonRepository] определяет метод для сохранения предложений в базе данных.
 */
interface PokemonRepository {
    /**
     * Сохраняет предложения в базе данных.
     * @param pokemon Сущность предложений [PokemonEntity], которая будет сохранена.
     */
    suspend fun savePokemon(pokemon: PokemonEntity)
}
