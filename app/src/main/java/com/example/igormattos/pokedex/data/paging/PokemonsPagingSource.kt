package com.example.igormattos.pokedex.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.igormattos.pokedex.data.services.PokemonService
import com.example.igormattos.pokedex.data.model.Result

class PokemonsPagingSource(private val service: PokemonService) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val currentPage = params.key ?: 1
            val response = service.listPokemons(10)
            val responseData = mutableListOf<Result>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = if (data.isEmpty()) null else currentPage.plus(1)
            )

        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

}