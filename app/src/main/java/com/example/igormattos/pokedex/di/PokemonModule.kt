package com.example.igormattos.pokedex.di

import com.example.igormattos.pokedex.data.services.PokemonService
import com.example.igormattos.pokedex.data.repository.PokemonRepository
import com.example.igormattos.pokedex.data.repository.PokemonRepositoryImpl
import com.example.igormattos.pokedex.domain.GetPokemon
import com.example.igormattos.pokedex.domain.GetPokemonsUseCase
import com.example.igormattos.pokedex.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() : PokemonService =
        Retrofit.Builder()
            .baseUrl(Constants.URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        repository: PokemonRepositoryImpl
    ) : PokemonRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class GetPokemonModule{

    @Binds
    @Singleton
    abstract fun bindMyUseCase(
        getPokemon: GetPokemon
    ) : GetPokemonsUseCase
}