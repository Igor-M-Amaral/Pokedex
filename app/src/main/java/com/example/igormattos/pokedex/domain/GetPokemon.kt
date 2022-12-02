package com.example.igormattos.pokedex.domain

import com.example.igormattos.pokedex.data.repository.PokemonRepository
import com.example.igormattos.pokedex.domain.model.Pokemons
import javax.inject.Inject

class GetPokemon @Inject constructor(private val repository: PokemonRepository) : GetPokemonsUseCase {
    override suspend fun invoke(): Pokemons {
        return repository.getPokemons()
    }
}