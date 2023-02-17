package com.example.gameapi_jpc.data.remote

import com.example.gameapi_jpc.data.remote.models.GamesModel
import com.example.gameapi_jpc.data.remote.models.SpecificGameModel
import com.example.gameapi_jpc.util.Constants.Companion.GAME_ENDPOINT
import com.example.gameapi_jpc.util.Constants.Companion.GAME_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApi {
    @GET(GAME_ENDPOINT)
    suspend fun getGames(): Response<List<GamesModel>>
    @GET(GAME_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id")id: Int): Response<SpecificGameModel>

}