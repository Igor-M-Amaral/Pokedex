package com.example.igormattos.pokedex.domain

import com.example.igormattos.pokedex.domain.model.Pokemons

interface GetPokemonsUseCase{
    suspend operator fun invoke() : Pokemons
}