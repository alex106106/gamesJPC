package com.example.gameapi_jpc.repo

import com.example.gameapi_jpc.data.remote.GameService
import com.example.gameapi_jpc.domain.items.GameItems
import com.example.gameapi_jpc.domain.items.SpecificGamesItems
import com.example.gameapi_jpc.domain.items.toGameItems
import com.example.gameapi_jpc.domain.items.toSpecificGamesItem
import javax.inject.Inject

class GamesRepository @Inject constructor(private val gameService: GameService) {
    suspend fun getGames(): List<GameItems>{
        return gameService.getGames().map {
            it.toGameItems()
        }
    }
    suspend fun getGamesById(id: Int): SpecificGamesItems{
        return gameService.getGameById(id).toSpecificGamesItem()
    }
}