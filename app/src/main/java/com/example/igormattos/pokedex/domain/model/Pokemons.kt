package com.example.igormattos.pokedex.domain.model

import com.example.igormattos.pokedex.data.model.Result

data class Pokemons(
    val count: Int,
    val next: String,
    val previous: Any?,
    val results: List<Result>
)
