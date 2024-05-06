package ru.itis.kpfu.feature.detail.impl.presentation

import androidx.fragment.app.viewModels
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.base.BaseFragment
import ru.itis.kpfu.core.common.utils.withArguments
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreenModel
import ru.itis.kpfu.feature.detail.impl.databinding.FragmentPokemonDetailBinding
import ru.itis.kpfu.feature.detail.impl.di.PokemonDetailComponent

private const val ARG_KEY_MODEL = "ARG_KEY_MODEL"

internal class PokemonDetailFragment : BaseFragment<PokemonDetailViewModel, FragmentPokemonDetailBinding>(
    inflate = FragmentPokemonDetailBinding::inflate
) {
    override val viewModel: PokemonDetailViewModel by viewModels { viewModelFactory }

    override fun inject(applicationProvider: ApplicationProvider) {
        PokemonDetailComponent.init(
            applicationProvider = applicationProvider,
            model = arguments?.getParcelable(ARG_KEY_MODEL) ?: error("No model received")
        ).inject(this)
    }

    companion object {

        fun createInstance(model: PokemonDetailScreenModel) = PokemonDetailFragment()
            .withArguments { putParcelable(ARG_KEY_MODEL, model) }
    }

}
