package hoangloc.playcardapp.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hoangloc.playcardapp.ViewModel.PlayerViewModel

@Composable
fun NavigationGraph(viewModel: PlayerViewModel){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.loginPage, builder = {
            composable(route = Routes.loginPage, content = { loginscreen(navController) })
            composable(Routes.mainPage, content = { mainPage(viewModel) })
        })
    }
