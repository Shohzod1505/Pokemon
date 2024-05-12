package ru.itis.kpfu.core.network.di

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.itis.kpfu.core.network.BuildConfig
import ru.itis.kpfu.core.network.data.PokemonApi
import ru.itis.kpfu.core.network.data.repository.PokemonRepositoryImpl
import ru.itis.kpfu.core.network.domain.PokemonRepository
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
internal class NetworkModule {

    @Provides
    fun provideHttpClient(
        @Named("logging") loggingInterceptor: Interceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(10L, TimeUnit.SECONDS)
        .build()

    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient,
        gsonFactory: GsonConverterFactory,
        @Named("base_url") baseUrl: String,
    ): Retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(gsonFactory)
        .build()

    @Provides
    @Named("logging")
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Named("base_url")
    fun provideBaseUrl(): String = BuildConfig.API_ENDPOINT

    @Provides
    fun providePokemonApi(
        retrofit: Retrofit,
    ): PokemonApi = retrofit.create(PokemonApi::class.java)

    @Provides
    fun providePokemonRepository(
        pokemonApi: PokemonApi
    ): PokemonRepository = PokemonRepositoryImpl(pokemonApi)

}
