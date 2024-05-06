package ru.itis.kpfu.feature.list.impl.di

import dagger.BindsInstance
import dagger.Component
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.feature.list.api.PokemonListScreenModel
import ru.itis.kpfu.feature.list.impl.presentation.PokemonListFragment

@Component(
    dependencies = [
        ApplicationProvider::class
    ],
    modules = [
        PokemonListScreensModule::class,
        PokemonListViewModelModule::class
    ]
)
internal interface PokemonListComponent {

    companion object {

        fun init(
            applicationProvider: ApplicationProvider,
            model: PokemonListScreenModel,
        ): PokemonListComponent {
            return DaggerPokemonListComponent.factory()
                .create(applicationProvider, model)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance model: PokemonListScreenModel,
        ): PokemonListComponent
    }

    fun inject(fragment: PokemonListFragment)

}
