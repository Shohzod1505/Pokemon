package ru.itis.kpfu.core.network.data.repository

import ru.itis.kpfu.core.network.data.PokemonApi
import ru.itis.kpfu.core.network.data.response.PokemonListResponse
import ru.itis.kpfu.core.network.data.response.PokemonResponse
import ru.itis.kpfu.core.network.domain.PokemonRepository

internal class PokemonRepositoryImpl(
    private val pokemonApi: PokemonApi
): PokemonRepository {

    override suspend fun getPokemon(
        name: String?
    ): PokemonResponse = pokemonApi.getPokemon(name)

    override suspend fun getPokemonList(
        limit: Int
    ): PokemonListResponse = pokemonApi.getPokemonList(limit)

}
