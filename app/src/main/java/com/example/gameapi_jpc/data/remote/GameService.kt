package com.example.gameapi_jpc.data.remote

import com.example.gameapi_jpc.data.remote.models.GamesModel
import com.example.gameapi_jpc.data.remote.models.SpecificGameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameService @Inject constructor(private val gamesApi: GamesApi) {
    suspend fun getGames(): List<GamesModel>{
        return withContext(Dispatchers.IO){
            val games = gamesApi.getGames()
            games.body() ?: emptyList()
        }
    }
    suspend fun getGameById(id: Int): SpecificGameModel{
        return withContext(Dispatchers.IO){
            val game = gamesApi.getGameById(id)
            game.body()!!
        }
    }
}