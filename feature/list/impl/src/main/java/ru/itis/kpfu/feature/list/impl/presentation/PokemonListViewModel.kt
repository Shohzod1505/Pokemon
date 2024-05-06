package ru.itis.kpfu.feature.list.impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.itis.kpfu.core.common.resources.Resources
import ru.itis.kpfu.feature.list.api.PokemonListScreenModel
import javax.inject.Inject

internal class PokemonListViewModel @Inject constructor(
    private val router: Router,
    private val resources: Resources,
    private val model: PokemonListScreenModel,
) : ViewModel()
