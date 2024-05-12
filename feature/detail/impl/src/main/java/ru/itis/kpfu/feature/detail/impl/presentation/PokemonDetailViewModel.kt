package ru.itis.kpfu.feature.detail.impl.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.itis.kpfu.core.common.resources.Resources
import ru.itis.kpfu.core.network.data.response.PokemonResponse
import ru.itis.kpfu.core.network.domain.usecases.GetPokemonUseCase
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreenModel
import ru.itis.kpfu.feature.list.api.PokemonListScreen
import ru.itis.kpfu.feature.list.api.PokemonListScreenModel
import javax.inject.Inject

internal class PokemonDetailViewModel @Inject constructor(
    private val router: Router,
    private val resources: Resources,
    private val model: PokemonDetailScreenModel,
    private val getPokemonUseCase: GetPokemonUseCase,
    private val pokemonListScreen: PokemonListScreen,
) : ViewModel() {

    private val _pokemon = MutableLiveData<PokemonResponse?>()
    val pokemon: LiveData<PokemonResponse?> = _pokemon

    fun getPokemon(name: String) {
        viewModelScope.launch {
            _pokemon.value = async {
                getPokemonUseCase(name)
            }.await()
        }
    }

    fun onBackButtonClicked() {
        router.backTo(pokemonListScreen.invoke(PokemonListScreenModel(0)))
    }

}
