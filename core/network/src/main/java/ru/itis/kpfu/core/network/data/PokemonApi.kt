package ru.itis.kpfu.core.network.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.itis.kpfu.core.network.data.response.PokemonListResponse
import ru.itis.kpfu.core.network.data.response.PokemonResponse

internal interface PokemonApi {

    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("limit") limit: Int
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String?
    ): PokemonResponse

}
