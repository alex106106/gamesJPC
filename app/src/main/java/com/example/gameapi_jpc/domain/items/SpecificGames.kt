package com.example.gameapi_jpc.domain.items

import com.example.gameapi_jpc.data.remote.models.SpecificGameModel

data class SpecificGamesItems (
    val id: Int,
    val title: String,
    val thumbnail: String,
    val description: String,
        )

fun SpecificGameModel.toSpecificGamesItem() = SpecificGamesItems(id, title, thumbnail, description)