package com.example.pokeflex

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import android.content.res.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material3.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokeflex.spriteMap
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
        items(100) { index ->
            PokedexCard(index + 1, "glorp", PokemonType.ELECTRIC)
        }
    }
}

@Composable
// note that sprite is actually a Resource ID, which is actually an int for reasons
// that i can't explain.
fun PokedexCard(id: Int, name: String, type: PokemonType) {
    val defaultMod: Modifier = Modifier.size(60.dp)
        Row(modifier = Modifier.width(350.dp), verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier.border(BorderStroke(3.dp, Color.Gray)).width(300.dp).height(140.dp).padding(6.dp)) {
            Image(painter = painterResource(GetPokemonSpriteResourceID(id)), "pokemon :3", modifier = defaultMod)
            Text("gleep glorp")
            Image(painter = painterResource(GetPokemonTypeResourceID(type)), "pokemon type", modifier = defaultMod)
        }
    }
}
fun GetPokemonSpriteResourceID(pokemonId: Int): Int {
    if (pokemonId > 807 || pokemonId < 0) {
        return 807
    }
    return spriteMap[pokemonId]!!
}
fun GetPokemonTypeResourceID(type: PokemonType): Int  {
    return when(type) {
        PokemonType.NORMAL -> R.drawable.type_normal
        PokemonType.FIGHTING -> R.drawable.type_fighting
        PokemonType.FLYING -> R.drawable.type_flying
        PokemonType.POISON -> R.drawable.type_poison
        PokemonType.GROUND -> R.drawable.type_ground
        PokemonType.ROCK -> R.drawable.type_rock
        PokemonType.BUG -> R.drawable.type_bug
        PokemonType.GHOST -> R.drawable.type_ghost
        PokemonType.STEEL -> R.drawable.type_steel
        PokemonType.FIRE -> R.drawable.type_fire
        PokemonType.WATER -> R.drawable.type_water
        PokemonType.GRASS -> R.drawable.type_grass
        PokemonType.ELECTRIC -> R.drawable.type_electric
        PokemonType.PSYCHIC -> R.drawable.type_psychic
        PokemonType.ICE -> R.drawable.type_ice
        PokemonType.DRAGON -> R.drawable.type_dragon
        PokemonType.DARK -> R.drawable.type_dark
        PokemonType.FAIRY -> R.drawable.type_fairy
    }
}