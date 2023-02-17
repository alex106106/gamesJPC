package com.example.gameapi_jpc.domain

import com.example.gameapi_jpc.domain.items.GameItems
import com.example.gameapi_jpc.repo.GamesRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(val gamesRepository: GamesRepository) {
    suspend operator fun invoke(): List<GameItems>{
        return gamesRepository.getGames().shuffled()
    }
}