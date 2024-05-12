package ru.itis.kpfu.core.network.domain.usecases

import ru.itis.kpfu.core.network.data.response.PokemonListResponse
import ru.itis.kpfu.core.network.domain.PokemonRepository
import javax.inject.Inject

/**
 * Use case, выполняющий запрос на получение списка покемонов.
 *
 * @property pokemonRepository Репозиторий для получения списка покемонов.
 */
class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    /**
     * Выполняет запрос на получение списка покемонов с заданным лимитом.
     *
     * @param limit Лимит количества покемонов.
     * @return Список покемонов.
     */
    suspend operator fun invoke(
        limit: Int
    ) : PokemonListResponse = pokemonRepository.getPokemonList(limit)

}
