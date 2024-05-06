package ru.itis.kpfu.core.database.data.repository

import ru.itis.kpfu.core.database.data.dao.PokemonDao
import ru.itis.kpfu.core.database.data.entity.PokemonEntity
import ru.itis.kpfu.core.database.domain.PokemonRepository
import javax.inject.Inject

internal class PokemonRepositoryImpl @Inject constructor(
    private val pokemonDao: PokemonDao
) : PokemonRepository {

    override suspend fun savePokemon(pokemon: PokemonEntity) {
        pokemonDao.save(pokemon)
    }

}
