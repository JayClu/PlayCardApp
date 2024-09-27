package hoangloc.playcardapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hoangloc.playcardapp.R

@Composable
fun loginscreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.scoreboard_logo),
            contentDescription = "restaurant logo"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Welcome !",
            fontSize = 35.sp, fontWeight = FontWeight.Bold)
        Button(onClick ={
            navController.navigate(Routes.mainPage)
        }) {
            Text(text = "Login", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }
    }
}