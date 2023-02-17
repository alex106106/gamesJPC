package com.example.gameapi_jpc.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameapi_jpc.domain.GetGamesByIdUseCase
import com.example.gameapi_jpc.domain.GetGamesUseCase
import com.example.gameapi_jpc.domain.items.GameItems
import com.example.gameapi_jpc.domain.items.SpecificGamesItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGameUseCase: GetGamesUseCase,
    private val getGameByIdUseCase: GetGamesByIdUseCase): ViewModel(){

    private val _games = MutableLiveData<List<GameItems>>()
    val games: LiveData<List<GameItems>>get() = _games

    private val _game = MutableLiveData<SpecificGamesItems>()
    val game: LiveData<SpecificGamesItems> get() = _game

    init {
        getGames()
    }
    private fun getGames(){
        viewModelScope.launch {
            try {
                val games = getGameUseCase()
                _games.value = games
            }catch (_: Exception){}
        }
    }

    fun getGamesById(id: Int){
        viewModelScope.launch {
            try {
                val game = getGameByIdUseCase(id)
                _game.value = game
            }catch (_: Exception){}
        }
    }
}