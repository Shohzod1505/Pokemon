package ru.itis.kpfu.core.common.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Модуль Dagger для предоставления зависимости ViewModelProvider.Factory.
 * Он использует аннотацию @Binds для связывания реализации ViewModelFactory с интерфейсом ViewModelProvider.Factory.
 */
@Module
interface ViewModelFactoryModule {

    /**
     * Связывает реализацию [ViewModelFactory] с интерфейсом [ViewModelProvider.Factory].
     * @param viewModelFactory Реализация фабрики ViewModel.
     * @return Реализация ViewModelProvider.Factory.
     */
    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
