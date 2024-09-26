package hoangloc.playcardapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

import hoangloc.playcardapp.Entity.Player

@Database(entities = [Player::class], version = 1)

abstract class PlayerListDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "PlayerList_Db"
    }

    abstract fun getPlayerListDao(): PlayerListDAO
}