package com.example.imagegrid


import retrofit2.Call
import retrofit2.http.GET

// serviço que cria informa as rotas que vão ser chamadas, os parametros e os retornos
interface PokemonService {
    @GET("pokemon")
    fun getPokemons(): Call<PokemonAPIResponseDTO>
}