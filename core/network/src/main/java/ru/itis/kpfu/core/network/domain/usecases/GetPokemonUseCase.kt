package ru.itis.kpfu.core.network.domain.usecases

import ru.itis.kpfu.core.network.data.response.PokemonResponse
import ru.itis.kpfu.core.network.domain.PokemonRepository
import javax.inject.Inject

/**
 * Use case, выполняющий запрос на получение информации о покемоне.
 *
 * @property pokemonRepository Репозиторий для получения информации о покемоне.
 */
class GetPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    /**
     * Выполняет запрос на получение информации о покемоне с заданным именем.
     *
     * @param name Имя покемона.
     * @return Информация о покемоне.
     */
    suspend operator fun invoke(
        name: String
    ) : PokemonResponse = pokemonRepository.getPokemon(name)

}
