package hoangloc.playcardapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel: ViewModel() {
    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> = _players

    fun getAllPlayers(){
        _players.value = PlayerListManager.getAllPlayers()
    }

    fun addPlayer(name: String){
        PlayerListManager.addPlayer(name)
        getAllPlayers()
    }


    fun deletePlayer(id: Int){
        PlayerListManager.deletePlayer(id)
        getAllPlayers()
    }

}