package hoangloc.playcardapp.util

import hoangloc.playcardapp.Entity.Player
import hoangloc.playcardapp.db.PlayerListDAO


fun computePoints(id: Int, playerList: List<Player>):Int {

    val totalround = playerList.sumOf { it.winround }
    val totalPlayers = playerList.size
    val  player = playerList.find { it.id == id }?.copy() ?: return 0
    val newpoint = totalPlayers * player.winround - totalround

    return  newpoint
}
        // round = 3, player = 3 winround = 1
        // get = maxP -1
        // w*(p-1) - (r-w)
        // (get*wround - (totalround-wround)
        // wp-w-r+w = WP - R



// den day
// cbi tao function tinh point -> point- > sau do update vs id tung cai
