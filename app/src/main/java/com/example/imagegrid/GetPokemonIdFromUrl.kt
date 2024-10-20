package com.example.imagegrid

fun getPokemonIdFromUrl(pokemonUrl: String): Int {
    return pokemonUrl.split("/").dropLast(1).last().toInt()
}