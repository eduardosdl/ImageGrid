package com.example.imagegrid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imagegrid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /* OBJETIVO
    * o objetivo é criar varios cards que ja montamos antes
    * alterando apenas a informação do nome do pokemos, por enquanto
    * */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        // lista de pokemons (lembrando por enquanto temos apenas o nome)
        /* aqui temos uma lista estática do nosso "model"
        * mas pode ser por exemplo os dados de um array que vem da api
        * */
        val pokemonsList = listOf(
            Pokemon("Pikachu"),
            Pokemon("Charmander"),
            Pokemon("Squirtle"),
            Pokemon("Bulbasaur"),
            Pokemon("Eevee"),
            Pokemon("Pikachu"),
            Pokemon("Charmander"),
            Pokemon("Squirtle"),
            Pokemon("Bulbasaur"),
            Pokemon("Eevee")
        )

        /*
        * essa propriedade layoutManager pode ser inserida dentro do proprio xml
        * mas como queremos um grid precisamos usar o GridLayoutManager e
        * essa propriedade precisa de mais de um parametro por isso usamos aqui
        * */
        binding.pokemonRecycleView.layoutManager = GridLayoutManager(this, 2)
//        binding.pokemonRecycleView.layoutManager = LinearLayoutManager(this)

        val pokemonAdapter = PokemonAdapter(pokemonsList)
        binding.pokemonRecycleView.adapter = pokemonAdapter
    }
}