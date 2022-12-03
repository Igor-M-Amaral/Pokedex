package com.example.igormattos.pokedex.data.repository

import com.example.igormattos.pokedex.data.services.PokemonService
import com.example.igormattos.pokedex.data.model.toPokemons
import com.example.igormattos.pokedex.domain.model.Pokemons
import com.example.igormattos.pokedex.core.Output
import com.example.igormattos.pokedex.core.parseResponse
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val service: PokemonService) :
    PokemonRepository {
    override suspend fun getPokemons(): Pokemons {
        val result = service.listPokemons().parseResponse()

        return when (result){
            is Output.Success ->{
                val pokemonsResponseList = result.value

                pokemonsResponseList.toPokemons()
            }
            is Output.Failure -> throw  Exception()
        }

    }

}