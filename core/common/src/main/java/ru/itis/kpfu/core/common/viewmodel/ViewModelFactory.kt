package ru.itis.kpfu.core.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * Фабрика для создания экземпляров ViewModel.
 * Этот класс реализует интерфейс [ViewModelProvider.Factory].
 * Он использует карту поставщиков [viewModels] для создания ViewModel.
 */
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelProvider =
            viewModels[modelClass] ?: error("$modelClass not found")
        return viewModelProvider.get() as T
    }
}
