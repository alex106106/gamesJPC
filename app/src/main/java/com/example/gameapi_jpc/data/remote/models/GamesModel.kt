package com.example.gameapi_jpc.data.remote.models

data class GamesModel(
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