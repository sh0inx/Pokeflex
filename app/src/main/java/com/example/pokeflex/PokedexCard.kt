package com.example.pokeflex

import android.graphics.drawable.Drawable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

enum class PokemonType {
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY
}


@Composable
fun PokedexGrid(width: Int, height: Int) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(12) {
            Text("boykisser :3")
        }
    }
}

@Composable
fun PokedexCard(id: Int, name: String, Sprite: Drawable, type:PokemonType) {

}
fun GetTypeDrawable(type: PokemonType) {

}