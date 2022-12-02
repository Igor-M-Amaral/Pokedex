package com.example.igormattos.pokedex.data.repository

import com.example.igormattos.pokedex.domain.model.Pokemons

interface PokemonRepository {

    suspend fun getPokemons() : Pokemons
}