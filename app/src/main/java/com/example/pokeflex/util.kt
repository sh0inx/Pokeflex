package com.example.pokeflex
import com.example.pokeflex.PokemonType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import java.io.InputStream
import android.content.res.Resources
import androidx.compose.ui.platform.LocalContext

@Serializable
data class Pokemon (val name:String, val id: Int, val type: List<PokemonType>)

class util {

//    fun parseJson(): List<Pokemon> {
//        return Json.decodeFromString(LocalContext.
//    }
}