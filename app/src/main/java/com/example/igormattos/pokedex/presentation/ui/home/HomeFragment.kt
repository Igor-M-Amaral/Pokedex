package com.example.igormattos.pokedex.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.igormattos.pokedex.databinding.FragmentHomeBinding
import com.example.igormattos.pokedex.presentation.adapter.PokemonsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
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
//        viewModel.pokemons.observe(viewLifecycleOwner, Observer { listResult ->
//            lifecycleScope.launch {
//                binding.recyclerviewCategory.layoutManager =
//                    LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//
//                binding.recyclerviewCategory.adapter = adapter
//
//                listResult.collect{
//                    adapter.submitData(it)
//                }
//            }
//        })

        viewModel.pokemons.observe(viewLifecycleOwner, Observer {
            binding.recyclerviewCategory.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

            binding.recyclerviewCategory.adapter = adapter

            adapter.submitList(it)
        })
    }


}