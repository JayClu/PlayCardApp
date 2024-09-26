package hoangloc.playcardapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object PlayerListManager {

    private val playersList = mutableListOf<Player>()

    fun getAllPlayers(): List<Player> {
        return playersList
    }

    fun addPlayer(name: String){
        playersList.add(Player(System.currentTimeMillis().toInt()
            ,name = name))
    }

    fun deletePlayer(id: Int){
        playersList.removeIf{ it.id == id }
    }
}