package hoangloc.playcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import hoangloc.playcardapp.Screen.NavigationGraph
import hoangloc.playcardapp.Screen.Scoreboard
import hoangloc.playcardapp.ViewModel.PlayerViewModel
import hoangloc.playcardapp.ui.theme.PlayCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val playerListViewModel = ViewModelProvider(this)[PlayerViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            PlayCardAppTheme {
                NavigationGraph(playerListViewModel)
            }
        }
    }
}

