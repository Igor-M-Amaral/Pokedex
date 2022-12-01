package com.example.igormattos.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.igormattos.pokedex.api.PokemonService
import com.example.igormattos.pokedex.data.model.PokemonsModel
import com.example.igormattos.pokedex.data.model.Result
import com.example.igormattos.pokedex.data.paging.PokemonsPagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val service: PokemonService) :
    PokemonRepository {
    override fun getPokemons(): Flow<PagingData<Result>> {
        val request = Pager(PagingConfig(pageSize = 1)){
            PokemonsPagingSource(service)
        }.flow
        return request
    }
}