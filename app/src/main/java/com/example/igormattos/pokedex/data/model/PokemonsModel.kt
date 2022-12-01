package com.example.igormattos.pokedex.data.model

data class PokemonsModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)