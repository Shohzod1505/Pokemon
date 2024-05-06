package ru.itis.kpfu.feature.list.impl.presentation

import androidx.fragment.app.viewModels
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.base.BaseFragment
import ru.itis.kpfu.core.common.utils.withArguments
import ru.itis.kpfu.feature.list.api.PokemonListScreenModel
import ru.itis.kpfu.feature.list.impl.databinding.FragmentPokemonListBinding
import ru.itis.kpfu.feature.list.impl.di.PokemonListComponent

private const val ARG_KEY_MODEL = "ARG_KEY_MODEL"

internal class PokemonListFragment : BaseFragment<PokemonListViewModel, FragmentPokemonListBinding>(
    inflate = FragmentPokemonListBinding::inflate
) {
    override val viewModel: PokemonListViewModel by viewModels { viewModelFactory }

    override fun inject(applicationProvider: ApplicationProvider) {
        PokemonListComponent.init(
            applicationProvider = applicationProvider,
            model = arguments?.getParcelable(ARG_KEY_MODEL) ?: error("No model received")
        ).inject(this)
    }

    companion object {

        fun createInstance(model: PokemonListScreenModel) = PokemonListFragment()
            .withArguments { putParcelable(ARG_KEY_MODEL, model) }
    }

}
