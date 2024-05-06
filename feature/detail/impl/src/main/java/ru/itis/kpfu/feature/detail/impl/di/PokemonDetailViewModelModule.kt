package ru.itis.kpfu.feature.detail.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.common.viewmodel.ViewModelKey
import ru.itis.kpfu.feature.detail.impl.presentation.PokemonDetailViewModel

@Module
internal interface PokemonDetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailViewModel::class)
    fun bindPokemonDetailViewModel(viewModel: PokemonDetailViewModel): ViewModel
}
