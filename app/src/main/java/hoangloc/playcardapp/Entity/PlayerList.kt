package hoangloc.playcardapp.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Player (

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,


    var name: String = "",
    var points: Long = 0,
    var winround: Int = 0
)