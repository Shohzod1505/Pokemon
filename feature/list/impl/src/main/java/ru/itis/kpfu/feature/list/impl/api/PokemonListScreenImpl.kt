package ru.itis.kpfu.feature.list.impl.api

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.itis.kpfu.feature.list.impl.presentation.PokemonListFragment
import ru.itis.kpfu.feature.list.api.PokemonListScreen
import ru.itis.kpfu.feature.list.api.PokemonListScreenModel
import javax.inject.Inject

/**
 * Реализация интерфейса [PokemonListScreen] на основе модели [PokemonListScreenModel].
 * @property screenKey Ключ экрана.
 */
class PokemonListScreenImpl @Inject constructor(): PokemonListScreen {

    override fun invoke(model: PokemonListScreenModel): Screen = FragmentScreen(key = screenKey) {
        PokemonListFragment.createInstance(model)
    }
}
