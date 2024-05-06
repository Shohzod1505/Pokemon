package ru.itis.kpfu.pokemon.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import ru.itis.kpfu.feature.list.api.PokemonListScreen
import ru.itis.kpfu.feature.list.api.PokemonListScreenModel
import javax.inject.Inject

internal class MainViewModel @Inject constructor(
    private val router: Router,
    private val cicerone: NavigatorHolder,
    private val pokemonListScreen: PokemonListScreen
) : ViewModel() {

    init {
        openPokemonListScreen()
    }

    fun setNavigator(navigator: Navigator) {
        cicerone.setNavigator(navigator)
    }

    fun removeNavigator() {
        cicerone.removeNavigator()
    }

    private fun openPokemonListScreen(){
        router.navigateTo(pokemonListScreen.invoke(PokemonListScreenModel(0)))
    }

}
