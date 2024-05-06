package ru.itis.kpfu.feature.detail.impl.api

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreen
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreenModel
import ru.itis.kpfu.feature.detail.impl.presentation.PokemonDetailFragment
import javax.inject.Inject

/**
 * Реализация интерфейса [PokemonDetailScreen] на основе модели [PokemonDetailScreenModel].
 * @property screenKey Ключ экрана.
 */
class PokemonDetailScreenImpl @Inject constructor(): PokemonDetailScreen {

    override fun invoke(model: PokemonDetailScreenModel): Screen = FragmentScreen(key = screenKey) {
        PokemonDetailFragment.createInstance(model)
    }
}
