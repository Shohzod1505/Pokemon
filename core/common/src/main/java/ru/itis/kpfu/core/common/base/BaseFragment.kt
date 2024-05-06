package ru.itis.kpfu.core.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.itis.kpfu.core.common.app.App
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * Абстрактный класс [BaseFragment] представляет базовый класс для фрагментов.
 * Он обеспечивает удобное внедрение зависимостей ViewModel и работу с привязками (view binding).
 * @param VM Тип ViewModel.
 * @param VB Тип привязки (view binding).
 * @property inflate Функция для создания экземпляра привязки.
 */
abstract class BaseFragment<VM : ViewModel, VB : ViewBinding>(
    private val inflate: (
        LayoutInflater,
        ViewGroup?,
        Boolean
    ) -> VB
) : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    protected abstract val viewModel: VM

    private var _binding: VB? = null
    val binding get() = requireNotNull(_binding) { "Binding not initialized" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject((requireActivity().application as App).getApplicationProvider())
        _binding = inflate.invoke(
            inflater,
            container,
            false
        )
        return binding.root
    }

    protected abstract fun inject(applicationProvider: ApplicationProvider)

    /**
     * Расширение для типа [Flow], позволяющее наблюдать за данными, эмитируемыми этим потоком,
     * в контексте жизненного цикла фрагмента.
     * @param action Функция, которая будет вызвана для каждого элемента, эмитируемого потоком.
     */
    fun <T> Flow<T>.observe(action: suspend (T) -> Unit) {
        this.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach(action)
            .launchIn(lifecycleScope)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
