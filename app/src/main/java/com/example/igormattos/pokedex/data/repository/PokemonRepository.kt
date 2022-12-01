package com.example.igormattos.pokedex.data.repository

import androidx.paging.PagingData
import com.example.igormattos.pokedex.data.model.Result
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemons() : Flow<PagingData<Result>>
}