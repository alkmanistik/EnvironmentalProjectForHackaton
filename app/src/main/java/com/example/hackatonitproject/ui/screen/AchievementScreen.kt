package com.example.hackatonitproject.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.hackatonitproject.data.DefaultData
import com.example.hackatonitproject.model.Achievement

@Composable
fun AchievementScreen(achievementList: List<Achievement>, modifier: Modifier){
    LazyColumn (
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize(),
    ){
        items(achievementList){
            achievement -> AchievementCard(achievement, Modifier)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AchievementCard(achievement: Achievement, modifier: Modifier){
    var selected by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        onClick = {selected = !selected},
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .fillMaxWidth()
    ){
        Column (
            modifier = Modifier.padding(16.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = achievement.image),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .size(68.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = achievement.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            }
            AnimatedVisibility(visible = selected) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = achievement.description)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment =Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()){
                        LinearProgressIndicator(
                            progress = achievement.nowProgress.toFloat() / achievement.maxProgress,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.weight(1f)
                                .height(8.dp)
                                .border(BorderStroke(1.dp,MaterialTheme.colorScheme.onBackground))
                        )
                        Text(
                            text = "${achievement.nowProgress}/${achievement.maxProgress}",
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .width(40.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AchievementScreenPreview(){
    AppTheme {
        Surface (
            color = MaterialTheme.colorScheme.background
        ){
            AchievementScreen(achievementList = DefaultData.achievementList, modifier = Modifier)
        }
    }

}