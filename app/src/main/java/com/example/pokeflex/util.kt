package com.example.pokeflex
import android.content.Context
import com.example.pokeflex.PokemonType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File
import kotlinx.serialization.decodeFromString
import java.io.InputStream
import android.content.res.Resources
import androidx.compose.ui.platform.LocalContext

@Serializable
data class Pokemon (val name:String, val id: Int, val type: List<PokemonType>)

class util {
fun parseJson (context: Context): List<Pokemon> {
    val jsonString = context.resources.openRawResource(R.raw.pokedata).toString()
    val json = Json { ignoreUnknownKeys = true}
    return json.decodeFromString<List<Pokemon>>(jsonString)
   }
}