package com.example.hackatonitproject.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.hackatonitproject.R
import com.example.hackatonitproject.data.DefaultData
import com.example.hackatonitproject.model.User

@Composable
fun ProfileScreen(user: User, modifier: Modifier){
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    val borderWidth = 4.dp
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp, end = 16.dp, start = 16.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.i),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .border(
                    BorderStroke(borderWidth, rainbowColorsBrush),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)
        )
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background, contentColor = MaterialTheme.colorScheme.primary)) {
            Text(
                text = "Изменить",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                )
        }
        Spacer(Modifier.height(40.dp))
        Column (
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Имя",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.width(100.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = user.name,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Никнейм",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.width(100.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = user.nickname,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Почта",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.width(100.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = user.email,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Телефон",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.width(100.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = user.phoneNumber,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Spacer(Modifier.height(40.dp))
        Spacer(Modifier.weight(1f))
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background, contentColor = Color.Red),
            modifier = Modifier.padding(bottom = 16.dp)
            ) {
            Text(
                text = "Выйти из аккаунта",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview(){
    AppTheme {
        Surface (
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ){
            ProfileScreen(user = DefaultData.user, modifier = Modifier)

        }
    }
}