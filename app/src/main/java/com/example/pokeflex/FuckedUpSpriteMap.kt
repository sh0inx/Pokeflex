package com.example.pokeflex

// DANGER
val spriteMap = (1..807).associateWith { pokemonId ->
    val resourceName = "mon_$pokemonId"
    val resourceId = R.drawable::class.java.getField(resourceName).getInt(null)
    resourceId
}
//val spriteMap = mapOf(
//    1 to R.drawable.mon_1
//)