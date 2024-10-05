package com.example.pokeflex.jsonparse
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class Pokemon(
    val name: String,
    val type: List<String>,
    val id: Int,
    val sprite: String
)

@Serializable
data class Pokedex(
    val pokemon: List<Pokemon>
)

fun readJsonFile(filepath: String): Pokedex {
    val jsonString = File(filepath).readText() // Reading contents of the file as a string
    val json = Json { ignoreUnknownKeys = true}
    return json.decodeFromString<Pokedex>(jsonString)
}


