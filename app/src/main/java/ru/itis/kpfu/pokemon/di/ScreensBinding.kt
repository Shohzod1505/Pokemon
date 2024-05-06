package ru.itis.kpfu.pokemon.di

import dagger.Module
import ru.itis.kpfu.feature.detail.impl.di.PokemonDetailScreenModule
import ru.itis.kpfu.feature.list.impl.di.PokemonListScreenModule

@Module(
    includes = [
        PokemonListScreenModule::class,
        PokemonDetailScreenModule::class,
    ]
)
internal interface ScreensBinding
