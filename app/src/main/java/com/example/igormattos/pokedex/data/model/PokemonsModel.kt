package com.example.igormattos.pokedex.data.model

import com.example.igormattos.pokedex.domain.model.Pokemons

data class PokemonsModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)

fun PokemonsModel.toPokemons() = Pokemons(
    count = count,
    next = next,
    previous = previous,
    results = results
)