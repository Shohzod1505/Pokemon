package ru.itis.kpfu.pokemon.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.pokemon.presentation.MainViewModel
import ru.itis.kpfu.core.common.viewmodel.ViewModelKey

@Module
internal interface MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
