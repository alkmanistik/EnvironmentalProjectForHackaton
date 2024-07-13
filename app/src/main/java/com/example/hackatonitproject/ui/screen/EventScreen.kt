package com.example.hackatonitproject.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hackatonitproject.model.Event

@Composable
fun EventScreen(eventList: List<Event>, navEventController: NavHostController,modifier: Modifier){
    val navEventController = rememberNavController()
    NavHost(navController = navEventController, startDestination = "eventList") {
        composable("eventList"){
            EventList(eventList, navEventController, Modifier)
        }
        composable("eventPage"){
            EventPage(event = eventList[0], navEventController, modifier = Modifier)
        }
    }
}

@Composable
fun EventList(eventList: List<Event>, navEventController: NavHostController, modifier: Modifier){
    LazyColumn (
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize(),
    ){
        item{
            Card {
                Text(text = "Точки приёма сортированного мусора", fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))
            }
        }
        items(eventList){
                event -> EventCard(event, {
                                          navEventController.navigate("eventPage")
        }, Modifier)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCard(event: Event, onClick: () -> Unit, modifier: Modifier){
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ){
            Image(
                painter = painterResource(id = event.image),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = event.title,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun EventPage(event: Event, navEventController: NavHostController, modifier: Modifier){
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Image(painter = painterResource(id = event.imageFull), contentScale = ContentScale.Crop, contentDescription = null, modifier = Modifier.clip(
            RoundedCornerShape(16.dp)
        ))
        Text(text = event.title, fontWeight = FontWeight.Bold)
        Text(text = event.description)
        Spacer(modifier = Modifier.weight(1f))
        Row(){
            Button(onClick = { navEventController.popBackStack("eventList", inclusive = false) }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)) {
                Text(text = "Пойду")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { navEventController.popBackStack("eventList", inclusive = false)}) {
                Text(text = "Вернуться")
            }
        }
    }
}

