package ru.itis.kpfu.core.network.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.itis.kpfu.core.network.data.response.PokemonResponse

internal interface PokemonApi {

    @GET("everything")
    suspend fun getPokemon(
        @Query("q") query: String?
    ): PokemonResponse

}
