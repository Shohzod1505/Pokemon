package ru.itis.kpfu.core.database.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.itis.kpfu.core.database.data.AppDatabase
import ru.itis.kpfu.core.database.data.dao.PokemonDao
import ru.itis.kpfu.core.database.data.repository.PokemonRepositoryImpl
import ru.itis.kpfu.core.database.domain.PokemonRepository
import javax.inject.Singleton

@Module
internal abstract class DatabaseModule {

    @Singleton
    @Binds
    abstract fun providePokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository

    companion object {

        @Singleton
        @Provides
        fun getRoomDatabaseInstance(
            context: Context
        ): AppDatabase = AppDatabase.getAppDatabaseInstance(context)

        @Singleton
        @Provides
        fun getPokemonDao(
            appDatabase: AppDatabase
        ): PokemonDao = appDatabase.getPokemonDao()

    }
}
