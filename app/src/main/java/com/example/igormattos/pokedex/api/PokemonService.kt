package com.example.igormattos.pokedex.api

import com.example.igormattos.pokedex.data.model.PokemonsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun listPokemons(@Query("limit") limit: Int = 10): Response<PokemonsModel>

}