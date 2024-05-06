package ru.itis.kpfu.feature.detail.impl.di

import dagger.BindsInstance
import dagger.Component
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.feature.detail.api.PokemonDetailScreenModel
import ru.itis.kpfu.feature.detail.impl.presentation.PokemonDetailFragment

@Component(
    dependencies = [
        ApplicationProvider::class
    ],
    modules = [
        PokemonDetailScreensModule::class,
        PokemonDetailViewModelModule::class
    ]
)
internal interface PokemonDetailComponent {

    companion object {

        fun init(
            applicationProvider: ApplicationProvider,
            model: PokemonDetailScreenModel,
        ): PokemonDetailComponent {
            return DaggerPokemonDetailComponent.factory()
                .create(applicationProvider, model)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance model: PokemonDetailScreenModel,
        ): PokemonDetailComponent
    }

    fun inject(fragment: PokemonDetailFragment)

}
