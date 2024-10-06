package com.example.pokeflex

import android.content.Context
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Pokemon(val name: String, val id: Int, val types: List<String>)

fun parseJson(context: Context): List<Pokemon> {
    val jsonString =
        context.resources.openRawResource(R.raw.pokedata).reader().readLines().joinToString("\n")
    val json = Json { ignoreUnknownKeys = true }
    return json.decodeFromString<List<Pokemon>>(jsonString)
}
// maybe we dont need the class
//class Util {
//
//}