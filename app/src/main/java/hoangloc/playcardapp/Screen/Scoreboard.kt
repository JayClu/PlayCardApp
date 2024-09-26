package hoangloc.playcardapp.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import hoangloc.playcardapp.Entity.Player
import hoangloc.playcardapp.ViewModel.PlayerViewModel
import hoangloc.playcardapp.R

@Composable
fun Scoreboard(viewModel: PlayerViewModel) {

    val playerList by viewModel.plaList.observeAsState()

    var nameInput by remember {
        mutableStateOf("") }

   Surface (
       modifier = Modifier
           .fillMaxWidth()
           .padding(top = 40.dp),
   ){

       Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top
        ) {
           //Input list
           OutlinedTextField(value = nameInput, onValueChange =
           {nameInput = it}
           )

           //Add button
           Button(
               onClick = {
                   //add a  new once
                   viewModel.addPlayer(nameInput)
                   nameInput = ""
               },
               modifier = Modifier
                   .padding(10.dp)
                   .clip(RoundedCornerShape(10.dp))
           ){
               Text(text = "Add")
           }
           //ScoreBoard
            playerList?.let {
                LazyColumn (
                    content = {
                        itemsIndexed(it){
                                index: Int, item: Player ->
                            PlayerItem(item = item,
                                onDelete = {
                                viewModel.deletePlayer(item.id)
                            })
                        }
                    }
                )
            }?: Text(
               modifier = Modifier.padding(10.dp),
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                text = "No players")


        }

   }
}


@Composable
fun PlayerItem(item: Player, onDelete: () -> Unit){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.inversePrimary)
    ) {
        TextButton(onClick = {
            // add 1 point to player
        },
            modifier = Modifier.padding(2.dp).width(120.dp)
        ) {
            Text(
            //modifier = Modifier.padding(10.dp),
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            style = MaterialTheme.typography.titleLarge,
            text = item.name)
        }
        Text(
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            text = item.winround.toString())
        Text(
            //modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            text = item.points.toString())

        //delete button
        IconButton(onClick = onDelete
            //delete player
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "delete button")


        }
    }
}