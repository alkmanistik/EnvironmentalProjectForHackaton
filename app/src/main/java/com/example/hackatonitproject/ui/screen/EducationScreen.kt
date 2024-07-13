package com.example.hackatonitproject.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.hackatonitproject.data.DefaultData
import com.example.hackatonitproject.model.EducationPage

@Composable
fun EducationScreen(educationPageList: List<EducationPage>, onEducationClick: (EducationPage) -> Unit,  modifier: Modifier){
    LazyColumn (
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize(),
    ){
        items(educationPageList){
                educationPage -> EducationCard(educationPage = educationPage, onEducationClick, modifier = Modifier)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationCard(educationPage: EducationPage, onEducationClick: (EducationPage) -> Unit, modifier: Modifier){
    var selected by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        onClick = {
                  if(!selected){
                      selected = true
                  }
            else{
                onEducationClick(educationPage)
                  }
        },
        modifier = modifier
    ){
        Column {
            Text(
                text = stringResource(educationPage.title),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
            )
            Image(
                painter = painterResource(id = educationPage.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = stringResource(id = educationPage.description),
                    modifier = Modifier.padding(16.dp),
                )
            }
        }

    }
}

@Preview
@Composable
fun EducationPagePreview(){
    AppTheme {
        EducationCard(educationPage = DefaultData.educationPageList[1],{}, modifier = Modifier)
    }
}

@Preview
@Composable
fun EducationScreenPreview(){
    AppTheme {
        EducationScreen(educationPageList = DefaultData.educationPageList,{}, modifier = Modifier)
    }
}