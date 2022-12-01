package com.example.igormattos.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.igormattos.pokedex.data.model.PokemonsModel
import com.example.igormattos.pokedex.data.model.Result
import com.example.igormattos.pokedex.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListPokemonViewModel @Inject constructor(private val repository: PokemonRepository) :
    ViewModel() {

    private val _pokemons = MutableLiveData<Flow<PagingData<Result>>>(emptyFlow())
    val pokemons: LiveData<Flow<PagingData<Result>>> = _pokemons

        fun getPokemons(){
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val result = repository.getPokemons()
                    _pokemons.postValue(result)

                }catch (e: Exception){

                }
            }
        }
}