package com.example.gameapi_jpc.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.gameapi_jpc.domain.items.GameItems
import com.example.gameapi_jpc.ui.ViewModel.GameViewModel
import com.example.gameapi_jpc.ui.nav.Screens

@Composable
fun HomeScreen(gameViewModel: GameViewModel, navController: NavController) {
    val games = gameViewModel.games.observeAsState(listOf()).value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Games", fontWeight = FontWeight.Bold)
                }
            )
        }
    ) {
        LazyColumn{
            items(games){game ->
                GameCard(game = game, navController = navController)
            }
        }
    }
}

@Composable
fun GameCard(game: GameItems, navController: NavController) {
    Card(
        elevation = 7.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 7.dp, bottom = 7.dp, start = 14.dp, end = 14.dp)
            .clickable {
                navController.navigate(Screens.Detail.route + "/${game.id}")
            }
    ) {
        Row{
            Image(painter = rememberImagePainter(game.thumbnail), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(175.dp)
                .height(115.dp))

            Column(modifier = Modifier
                .padding(10.dp)
                .align(CenterVertically)) {
                Text(text = game.title,
                    fontWeight = FontWeight.Bold)
                Text(text = game.short_description,
                    maxLines = 2, overflow = TextOverflow.Ellipsis)

            }
        }
    }
}


