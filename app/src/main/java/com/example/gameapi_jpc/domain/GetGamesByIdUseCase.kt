package com.example.gameapi_jpc.domain

import com.example.gameapi_jpc.domain.items.SpecificGamesItems
import com.example.gameapi_jpc.repo.GamesRepository
import javax.inject.Inject

class GetGamesByIdUseCase @Inject constructor(val gamesRepository: GamesRepository) {
    suspend operator fun invoke(id:Int): SpecificGamesItems{
        return gamesRepository.getGamesById(id)
    }
}