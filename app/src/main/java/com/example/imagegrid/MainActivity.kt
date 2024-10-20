package com.example.imagegrid

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagegrid.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        // mantenho a definição do tipo layout manager em grid
        binding.pokemonRecycleView.layoutManager = GridLayoutManager(this, 2)

        // faço a chamada do serviço que realiza a requisição a api por meio de callbacks
        RetrofitInstance.api.getPokemons().enqueue(object : Callback<PokemonAPIResponseDTO> {
            override fun onFailure(call: Call<PokemonAPIResponseDTO>, t: Throwable) {
                Log.e("app-log", "erro na chamada da api: ${t.message}")
            }

            override fun onResponse(
                call: Call<PokemonAPIResponseDTO>, response: Response<PokemonAPIResponseDTO>
            ) {
                val apiResponse = response.body()
                if (apiResponse != null) {
                    val pokemonImageUrl =
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${
                            getPokemonIdFromUrl(apiResponse.results[0].url)
                        }.png"
                    Log.e("app-log", "erro na chamada da api: $pokemonImageUrl")

                    val pokemonAdapter = PokemonAdapter(apiResponse.results)
                    binding.pokemonRecycleView.adapter = pokemonAdapter
                }
            }
        })
    }
}