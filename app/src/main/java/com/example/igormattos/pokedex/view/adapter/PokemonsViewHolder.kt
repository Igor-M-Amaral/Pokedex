package com.example.igormattos.pokedex.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.igormattos.pokedex.data.model.Result
import com.example.igormattos.pokedex.databinding.RowPokemonsBinding
import com.example.igormattos.pokedex.utils.Constants

class PokemonsViewHolder(private val binding: RowPokemonsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(pokemon: Result) {
        binding.textViewName.text = pokemon.name
        val pokemonId = pokemon.url
            .replace("https://pokeapi.co/api/v2/pokemon/", "")
            .replace("/", "").padStart(3, '0')

        binding.textViewID.text = pokemonId

        pokemon.let {
            Glide.with(itemView.context)
                .load(Constants.URL.IMAGE + pokemonId + ".png")
                .into(binding.imageView)
        }
    }
}