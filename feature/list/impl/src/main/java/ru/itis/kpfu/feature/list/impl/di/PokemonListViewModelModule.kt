package ru.itis.kpfu.feature.list.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.common.viewmodel.ViewModelKey
import ru.itis.kpfu.feature.list.impl.presentation.PokemonListViewModel

@Module
internal interface PokemonListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonListViewModel::class)
    fun bindPokemonListViewModel(viewModel: PokemonListViewModel): ViewModel
}
