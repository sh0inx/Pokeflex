package com.example.pokeflex

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material3.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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

fun convertToTypeEnum(type: String): PokemonType {
    return when (type) {
        "normal" -> PokemonType.NORMAL
        "fighting" -> PokemonType.FIGHTING
        "flying" -> PokemonType.FLYING
        "poison" -> PokemonType.POISON
        "ground" -> PokemonType.GROUND
        "rock" -> PokemonType.ROCK
        "bug" -> PokemonType.BUG
        "ghost" -> PokemonType.GHOST
        "steel" -> PokemonType.STEEL
        "fire" -> PokemonType.FIRE
        "water" -> PokemonType.WATER
        "grass" -> PokemonType.GRASS
        "electric" -> PokemonType.ELECTRIC
        "psychic" -> PokemonType.PSYCHIC
        "ice" -> PokemonType.ICE
        "dragon" -> PokemonType.DRAGON
        "dark" -> PokemonType.DARK
        "fairy" -> PokemonType.FAIRY
        else -> PokemonType.NORMAL
    }
}

fun convertToTypeEnum(types: List<String>): List<PokemonType> {
    return types.map { type ->
        when (type) {
            "normal" -> PokemonType.NORMAL
            "fighting" -> PokemonType.FIGHTING
            "flying" -> PokemonType.FLYING
            "poison" -> PokemonType.POISON
            "ground" -> PokemonType.GROUND
            "rock" -> PokemonType.ROCK
            "bug" -> PokemonType.BUG
            "ghost" -> PokemonType.GHOST
            "steel" -> PokemonType.STEEL
            "fire" -> PokemonType.FIRE
            "water" -> PokemonType.WATER
            "grass" -> PokemonType.GRASS
            "electric" -> PokemonType.ELECTRIC
            "psychic" -> PokemonType.PSYCHIC
            "ice" -> PokemonType.ICE
            "dragon" -> PokemonType.DRAGON
            "dark" -> PokemonType.DARK
            "fairy" -> PokemonType.FAIRY
            else -> PokemonType.NORMAL
        }
    }
}

@Composable
fun PokedexGrid(width: Int, height: Int, pokemonList: List<Pokemon>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(pokemonList.count()) { index ->
            PokedexCard(
                index + 1,
                pokemonList[index].name,
                convertToTypeEnum(pokemonList[index].types)
            )
        }
    }
}

@Composable
// note that sprite is actually a Resource ID, which is actually an int for reasons
// that i can't explain.
fun PokedexCard(id: Int, name: String, types: List<PokemonType>) {
    val defaultMod: Modifier = Modifier.size(60.dp)
    Row(modifier = Modifier.width(350.dp), verticalAlignment = Alignment.CenterVertically) {
        Card(
            modifier = Modifier
                .border(BorderStroke(3.dp, Color.Gray))
                .width(300.dp)
                .height(140.dp)
                .padding(6.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(GetPokemonSpriteResourceID(id)),
                    "pokemon :3",
                    modifier = defaultMod
                )
                Text(
                    modifier = Modifier.padding(7.dp),
                    text = name.replaceFirstChar { x -> x.uppercase() })
            }
            Column(
                modifier = Modifier
                    .width(64.dp)
                    .height(128.dp)
                    .padding(8.dp)
                    .align(alignment = Alignment.End), verticalArrangement = Arrangement.SpaceEvenly
            ) {
                for (type in types) {
                    Image(
                        painter = painterResource(GetPokemonTypeResourceID(type)),
                        "type",
                        modifier = Modifier
                            .scale(2F)
                            .align(alignment = Alignment.End)
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}

fun GetPokemonSpriteResourceID(pokemonId: Int): Int {
    if (pokemonId > 807 || pokemonId < 0) {
        return 807
    }
    return spriteMap[pokemonId]!!
}

fun GetPokemonTypeResourceID(type: PokemonType): Int {
    return when (type) {
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