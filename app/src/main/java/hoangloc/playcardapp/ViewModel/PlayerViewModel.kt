package hoangloc.playcardapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hoangloc.playcardapp.Entity.Player
import hoangloc.playcardapp.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel: ViewModel() {
    //private val _players = MutableLiveData<List<Player>>()

    val playerListDao = MainApplication.playerListDatabase.getPlayerListDao()

    val plaList: LiveData<List<Player>> = playerListDao.getAllPlayerList()

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
}

