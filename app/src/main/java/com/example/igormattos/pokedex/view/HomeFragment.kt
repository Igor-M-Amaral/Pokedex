package com.example.igormattos.pokedex.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.igormattos.pokedex.databinding.FragmentHomeBinding
import com.example.igormattos.pokedex.view.adapter.PokemonsAdapter
import com.example.igormattos.pokedex.viewmodel.ListPokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: ListPokemonViewModel by viewModels()
    private val adapter = PokemonsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        viewModel.getPokemons()

        observer()

        return binding.root
    }

    private fun observer() {
        viewModel.pokemons.observe(viewLifecycleOwner, Observer { listResult ->
            lifecycleScope.launch {
                binding.recyclerviewCategory.layoutManager =
                    LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                binding.recyclerviewCategory.adapter = adapter

                listResult.collect{
                    adapter.submitData(it)
                }
            }
        })
    }


}