package ru.itis.kpfu.feature.list.impl.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.itis.kpfu.core.common.resources.Resources
import ru.itis.kpfu.core.network.data.response.PokemonResponse
import ru.itis.kpfu.core.network.domain.usecases.GetPokemonListUseCase
import ru.itis.kpfu.core.network.domain.usecases.GetPokemonUseCase
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreen
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreenModel
import ru.itis.kpfu.feature.list.api.PokemonListScreenModel
import javax.inject.Inject

internal class PokemonListViewModel @Inject constructor(
    private val router: Router,
    private val resources: Resources,
    private val model: PokemonListScreenModel,
    private val getPokemonUseCase: GetPokemonUseCase,
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val pokemonDetailScreen: PokemonDetailScreen
) : ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonResponse>?>()
    val pokemonList: LiveData<List<PokemonResponse>?> = _pokemonList

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getPokemonList(limit: Int) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val list = async {
                    getPokemonListUseCase(limit).results
                }.await()

                val pokemonResponses = list?.mapNotNull { result ->
                    result?.let {
                        async {
                            getPokemonUseCase(result.name.toString())
                        }
                    }
                }?.map { asyncPokemonResponse ->
                    asyncPokemonResponse.await()
                }
                _pokemonList.value = pokemonResponses
            } catch (_: Throwable) {
            } finally {
                _loading.value = false
            }
        }
    }

    fun onPokemonItemClicked(name: String?) {
        router.navigateTo(pokemonDetailScreen.invoke(PokemonDetailScreenModel(name)))
    }

}
