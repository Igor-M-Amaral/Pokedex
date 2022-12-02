package com.example.igormattos.pokedex.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.igormattos.pokedex.data.model.toPokemonsResult
import com.example.igormattos.pokedex.domain.GetPokemonsUseCase
import com.example.igormattos.pokedex.presentation.model.PokemonsResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPokemonsUseCase: GetPokemonsUseCase) :
    ViewModel() {

    private val _pokemons = MutableLiveData<List<PokemonsResult>>()
    val pokemons: LiveData<List<PokemonsResult>> = _pokemons

        fun getPokemons(){
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val result = getPokemonsUseCase.invoke()
                    val s = result!!.results.map {
                        it.toPokemonsResult()
                    }
                    _pokemons.postValue(s)

                }catch (e: Exception){
                    val s = e.message
                }
            }
        }
}