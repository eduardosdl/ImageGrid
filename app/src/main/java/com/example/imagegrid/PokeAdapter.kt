package com.example.imagegrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagegrid.databinding.ItemPokeCardBinding

/*
* o adapter serve para receber a lista e fazer a iteração entre
* cada item da lista enviada e assim ir montando a interface
*
* Ou seja:
*  - o adapter recebe nossa lista
*  - por baixo dos panos é como se ele realizasse um for
*    em todos os elementos da lista enviada
*  - a cada item que ele percorre ele envia para o viewholder
*
* o view holder serve para receber os dados e fazer a vinculação
* ao layout
*
* ou seja:
*  - o view holser recebe o item que esta sendo iterado
*  - vincula a propriedade ao layout
*  - ex: propriedade name -> vai ser mostrada no elemento cardName
* */
class PokemonAdapter(private val pokemons: List<Pokemon>) :
    RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokeCardBinding.inflate(inflater, parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }
}

// view holder personalizado
class PokemonViewHolder(private val binding: ItemPokeCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(pokemon: Pokemon) {
        binding.cardName.text = pokemon.name
    }
}
