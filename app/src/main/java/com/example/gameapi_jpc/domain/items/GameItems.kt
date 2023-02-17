package com.example.gameapi_jpc.domain.items

import com.example.gameapi_jpc.data.remote.models.GamesModel

data class GameItems (
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val developer: String,
    val freetogame_profile_url: String,
    val game_url: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val release_date: String,
        )

fun GamesModel.toGameItems() = GameItems(id, title, thumbnail, short_description, developer, freetogame_profile_url, game_url, genre, platform, publisher, release_date)