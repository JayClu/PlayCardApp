package hoangloc.playcardapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hoangloc.playcardapp.Entity.Player


@Dao
interface PlayerListDAO {
    @Query("SELECT * FROM PLayer")
    fun getAllPlayerList(): LiveData<List<Player>>

    //@Query("INSERT INTO Player")
    @Insert
    fun addPlayer(player: Player)

    @Query("DELETE FROM Player WHERE id = :id")
    //@Delete
    fun deletePlayer(id: Int)
}