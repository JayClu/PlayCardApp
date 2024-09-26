package hoangloc.playcardapp

import android.app.Application
import androidx.room.Room
import hoangloc.playcardapp.db.PlayerListDatabase

class MainApplication : Application() {

    companion object{
        lateinit var playerListDatabase: PlayerListDatabase
    }

    override fun onCreate() {
        super.onCreate()
        playerListDatabase = Room.databaseBuilder(
            applicationContext,
            PlayerListDatabase::class.java,
            PlayerListDatabase.DATABASE_NAME
        ).build()
    }


}