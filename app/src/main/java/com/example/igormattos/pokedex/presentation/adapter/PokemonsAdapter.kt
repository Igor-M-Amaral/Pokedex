package com.example.igormattos.pokedex.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.igormattos.pokedex.databinding.RowPokemonsBinding
import com.example.igormattos.pokedex.presentation.model.PokemonsResult

class PokemonsAdapter : ListAdapter<PokemonsResult, PokemonsViewHolder>(PokemonsToCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        return PokemonsViewHolder(RowPokemonsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PokemonsViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }


    class PokemonsToCallBack : DiffUtil.ItemCallback<PokemonsResult>() {
        override fun areItemsTheSame(oldItem: PokemonsResult, newItem: PokemonsResult): Boolean {
           return oldItem.pokemonName == newItem.pokemonName
        }

        override fun areContentsTheSame(oldItem: PokemonsResult, newItem: PokemonsResult): Boolean {
            return oldItem.pokemonName == newItem.pokemonName
        }
    }
}
