package hoangloc.playcardapp.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hoangloc.playcardapp.Entity.Player
import hoangloc.playcardapp.MainApplication
import hoangloc.playcardapp.util.computePoints
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel: ViewModel() {
    //private val _players = MutableLiveData<List<Player>>()

    val playerListDao = MainApplication.playerListDatabase.getPlayerListDao()

    val playList: LiveData<List<Player>> = playerListDao.getAllPlayerList()


    //val totalRound:Int = playList.value?.sumOf { it.winround } ?: 0
    //val getPerRound:Int = playList.value?.size ?: 0 -1

    fun addPlayer(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            playerListDao.addPlayer(Player(name = name))
        }
    }

    fun deletePlayer(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            playerListDao.deletePlayer(id)
        }
    }

//    fun updatePoints(playerList: List<Player>) {
//        viewModelScope.launch(Dispatchers.IO) {
//            computePoints(playerList)
//            for (player in playerList) {
//            playerListDao.updatePoints(player.id, player.points)
//            }
//        }
//    }
//    fun updatePoints(){
//        for (player in playList.value ?: emptyList()) {
//            playerListDao.updatePoints(player.id, computePoints(player.id, playList.value ?: emptyList()))
//        }
//    }
//fun updatePoints() {
//    playList.observeForever { players ->
//        if (players != null) {
//            for (player in players) {
//                playerListDao.updatePoints(player.id, computePoints(player.id, players))
//            }
//        }
//    }
//}
//    fun updatePoints(playList: List<Player>) {
//        viewModelScope.launch(Dispatchers.IO){
//            playerListDao.updatePoints(playList)
//        }
//    }
//    // Compute points for each player
//fun computePoints() {
//
//    val totalround = playList.value?.sumOf { it.winround } ?: 0
//    //Log.d("totalround", totalround.toString())
//
//    val totalplayer = playList.value?.size ?: 0
//    //Log.d("totalplayer", totalplayer.toString())
//
//    val subPlaylist = playList.value ?: emptyList()
//
//    for (player in subPlaylist) {
//        val newpoint = totalplayer * player.winround - totalround
//        Log.d("newpoint", newpoint.toString())
//        playerListDao.updatePoints(player.id, newpoint)
//    }
    // round = 1, player = 3 winround = 1
    // get = maxP -1   = 2
    // w*(p-1) - (r-w) =  = wp - w -r + W = wp - r
    // (get*wround - (totalround-wwround)
    //(get+1)wround - total

//}
    // update
    //test
//    fun updatePlayer() {
//    viewModelScope.launch(Dispatchers.IO) {
//        for (player in playList.value ?: emptyList()) {
//
//            playerListDao.updatePlayer(player.id,
//                computePoints(player.id, playList.value ?: emptyList()))
//        }
//    }
//}

    fun insWinround(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            playerListDao.insWinround(id)

            //computePoints()
            //updatePoints()
            //updatePoints(playList.value ?: emptyList())
        }
    }

    fun decWinround(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            playerListDao.decWinround(id)
            //computePoints()
            //updatePoints()
            //playerListDao.updatePoints(id, computePoints(id, playList.value ?: emptyList()))
            //updatePoints(playList.value?: emptyList())
        }
    }
}



