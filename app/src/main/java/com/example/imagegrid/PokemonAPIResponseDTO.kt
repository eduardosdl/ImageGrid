package com.example.imagegrid

import com.google.gson.annotations.SerializedName

// interface que contem todos os campos retornados da api
data class PokemonAPIResponseDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("nest")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<Pokemon>
)