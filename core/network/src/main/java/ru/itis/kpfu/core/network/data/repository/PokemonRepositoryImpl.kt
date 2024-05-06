package ru.itis.kpfu.core.network.data.repository

import ru.itis.kpfu.core.network.data.PokemonApi
import ru.itis.kpfu.core.network.data.response.PokemonResponse
import ru.itis.kpfu.core.network.domain.PokemonRepository

internal class PokemonRepositoryImpl(
    private val pokemonApi: PokemonApi
): PokemonRepository {

    override suspend fun getPokemon(
        query: String?
    ): PokemonResponse = pokemonApi.getPokemon(query)

}
