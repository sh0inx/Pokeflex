package com.example.pokeflex

public val spriteMap = (1..807).associateWith { pokemonId ->
    val resourceName = "mon_$pokemonId"
    val resourceId = R.drawable::class.java.getField(resourceName).getInt(null)
    resourceId
}