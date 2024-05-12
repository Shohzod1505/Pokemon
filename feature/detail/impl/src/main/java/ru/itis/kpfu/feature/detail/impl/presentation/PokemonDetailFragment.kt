package ru.itis.kpfu.feature.detail.impl.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import coil.load
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.base.BaseFragment
import ru.itis.kpfu.core.common.utils.replacePokemonImageUrl
import ru.itis.kpfu.core.common.utils.withArguments
import ru.itis.kpfu.core.network.data.response.PokemonResponse
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreenModel
import ru.itis.kpfu.feature.detail.impl.databinding.FragmentPokemonDetailBinding
import ru.itis.kpfu.feature.detail.impl.di.PokemonDetailComponent
import java.util.Locale

private const val ARG_KEY_MODEL = "ARG_KEY_MODEL"

internal class PokemonDetailFragment :
    BaseFragment<PokemonDetailViewModel, FragmentPokemonDetailBinding>(
        inflate = FragmentPokemonDetailBinding::inflate
    ) {
    override val viewModel: PokemonDetailViewModel by viewModels { viewModelFactory }

    override fun inject(applicationProvider: ApplicationProvider) {
        PokemonDetailComponent.init(
            applicationProvider = applicationProvider,
            model = arguments?.getParcelable(ARG_KEY_MODEL) ?: error("No model received")
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model: PokemonDetailScreenModel? = arguments?.getParcelable(ARG_KEY_MODEL)
        viewModel.getPokemon(model?.name.toString())
        observeViewModel()
        onBack()
    }

    private fun observeViewModel() {
        with(viewModel) {
            pokemon.observe(viewLifecycleOwner) {
                fillPokemonInfo(it)
            }
        }
    }

    private fun fillPokemonInfo(pokemon: PokemonResponse?) {
        with(binding) {
            progressBar.visibility = View.VISIBLE
            pokemonImage.load(replacePokemonImageUrl(pokemon?.sprites?.frontDefault.toString())) {
                crossfade(true)
                listener(
                    onStart = {
                        progressBar.visibility = View.VISIBLE
                    },
                    onSuccess = { _, _ ->
                        progressBar.visibility = View.GONE
                    }
                )
            }
            pokemonName.text = pokemon?.name?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            }
            pokemonTypesValue.text = pokemon?.types?.joinToString(", ") { it.type?.name.orEmpty() }
            pokemonWeightValue.text = pokemon?.weight.toString()
            pokemonHeightValue.text = pokemon?.height.toString()
            pokemonAbilitiesValue.text =
                pokemon?.abilities?.joinToString(", ") { it.ability?.name.orEmpty() }
            val statsArray = pokemon?.stats?.joinToString(", ") {
                it.baseStat.toString()
            }?.split(", ")?.toTypedArray()
            pokemonHpValue.text = statsArray?.get(0) ?: "0"
            pokemonAttackValue.text = statsArray?.get(1) ?: "0"
            pokemonDefenseValue.text = statsArray?.get(2) ?: "0"
            pokemonSpecialAttackValue.text = statsArray?.get(3) ?: "0"
            pokemonSpecialDefenseValue.text = statsArray?.get(4) ?: "0"
            pokemonSpeedValue.text = statsArray?.get(5) ?: "0"
            Log.e("MY", "${pokemon?.stats?.joinToString(", ") { it.stat?.name.orEmpty() }}")
            Log.e("MY", "${pokemon?.stats?.joinToString(", ") { it.baseStat.toString() }}")
        }
    }

    private fun onBack() {
        binding.backButton.setOnClickListener {
            viewModel.onBackButtonClicked()
        }
    }

    companion object {

        fun createInstance(model: PokemonDetailScreenModel) = PokemonDetailFragment()
            .withArguments { putParcelable(ARG_KEY_MODEL, model) }
    }

}
