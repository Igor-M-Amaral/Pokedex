package com.example.igormattos.pokedex.data.model

import com.example.igormattos.pokedex.presentation.model.PokemonsResult

data class Result(
    val name: String,
    val url: String
)

fun Result.toPokemonsResult() = PokemonsResult(
    pokemonName = name,
    imageUrl = url
)