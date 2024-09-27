package hoangloc.playcardapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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

            //update points
    //@Query("UPDATE Player SET points = (:getPerRound+1)*winround - :totalround ")
    //@Update
    //fun updatePoints(playerList: List<Player>)
    //@Query("UPDATE Player SET points = :points WHERE id = :id")
    //@Query("SELECT winround FROM Player SET winround = :round")
    //fun updatePoints(round: Int)
    // test
//    @Query("UPDATE Player SET points = :newpoints WHERE id = :id")
//    fun updatePlayer(id: Int, newpoints: Int)

            //+ * points
    @Query("UPDATE Player SET winround = winround + 1 WHERE id = :id")
    fun insWinround(id: Int)

    @Query("UPDATE Player SET winround = winround - 1 WHERE id = :id")
    fun decWinround(id: Int)
}