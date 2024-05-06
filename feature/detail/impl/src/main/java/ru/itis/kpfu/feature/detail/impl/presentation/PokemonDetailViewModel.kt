package ru.itis.kpfu.feature.detail.impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.itis.kpfu.core.common.resources.Resources
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreenModel
import javax.inject.Inject

internal class PokemonDetailViewModel @Inject constructor(
    private val router: Router,
    private val resources: Resources,
    private val model: PokemonDetailScreenModel,
) : ViewModel()
