package ru.itis.kpfu.pokemon.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.itis.kpfu.core.common.app.App
import ru.itis.kpfu.core.common.viewmodel.ViewModelFactory
import ru.itis.kpfu.pokemon.R
import ru.itis.kpfu.pokemon.databinding.ActivityMainBinding
import ru.itis.kpfu.pokemon.di.MainComponent
import javax.inject.Inject

internal class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val navigator: Navigator = AppNavigator(this, R.id.fragment_container_view)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        MainComponent.init((applicationContext as App).getApplicationProvider())
            .inject(this)
    }

    override fun onResume() {
        super.onResume()
        viewModel.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeNavigator()
    }

}
