package com.example.imagegrid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// instancia do retrofit para fazer requisições
object RetrofitInstance {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val api: PokemonService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            // aqui fica qual o serviço que vai ser usado, pode ser implementado na chamada
            .create(PokemonService::class.java)
    }
}