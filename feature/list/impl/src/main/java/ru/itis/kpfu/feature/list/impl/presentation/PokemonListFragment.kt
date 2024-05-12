package ru.itis.kpfu.feature.list.impl.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.base.BaseFragment
import ru.itis.kpfu.core.common.utils.replacePokemonImageUrl
import ru.itis.kpfu.core.common.utils.withArguments
import ru.itis.kpfu.core.network.data.response.PokemonResponse
import ru.itis.kpfu.feature.list.api.PokemonListScreenModel
import ru.itis.kpfu.feature.list.impl.databinding.FragmentPokemonListBinding
import ru.itis.kpfu.feature.list.impl.databinding.ItemPokemonBinding
import ru.itis.kpfu.feature.list.impl.di.PokemonListComponent
import java.util.Locale

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }
        viewModel.getPokemonList(10)
        observeViewModel()
    }

    private fun pokemonDelegate() = adapterDelegateViewBinding<PokemonResponse, PokemonResponse, ItemPokemonBinding>(
        {layoutInflater, parent ->  ItemPokemonBinding.inflate(layoutInflater, parent, false)}
    ) {
        with(binding) {
            bind {
                progressBar.visibility = View.VISIBLE
                pokemonImage.load(replacePokemonImageUrl(item.sprites?.frontDefault.toString())) {
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
                pokemonName.text = item.name?.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
                pokemonTypes.text = item.types?.joinToString(", ") {it.type?.name.orEmpty()}
            }

            root.setOnClickListener {
                viewModel.onPokemonItemClicked(item.name)
            }
        }
    }

    private val adapterDelegate = ListDelegationAdapter(pokemonDelegate())

    private fun observeViewModel() {
        with(viewModel) {
            pokemonList.observe(viewLifecycleOwner) {
                initAdapter(it)
            }
            loading.observe(viewLifecycleOwner) {
                binding.progressBar.isVisible = it
            }
        }
    }

    private fun initAdapter(pokemonList: List<PokemonResponse>?) {

        adapterDelegate.apply {
            items = pokemonList
        }

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        with(binding.rvPokemons) {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = adapterDelegate
            addItemDecoration(divider)
        }
    }

    companion object {

        fun createInstance(model: PokemonListScreenModel) = PokemonListFragment()
            .withArguments { putParcelable(ARG_KEY_MODEL, model) }
    }

}
