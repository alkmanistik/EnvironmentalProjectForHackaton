package com.example.hackatonitproject.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hackatonitproject.data.DefaultData
import com.example.hackatonitproject.model.EducationPage
import com.example.hackatonitproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(onEducationClick: (EducationPage) -> Unit) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val navController = rememberNavController()
    val navEventController = rememberNavController()
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    when (selectedItemIndex) {
                        0 -> Text(text = "Обучающие материалы")
                        1 -> Text(text = "События")
                        2 -> Text(text = "Награды")
                        3 -> Text(text = "Профиль")
                        else -> Text(text = "Обучающие материалы")
                    }
                },
                actions = {
                    when (selectedItemIndex) {
                        0 -> IconButton(onClick = {}){ Icon(imageVector = Icons.Default.Search, contentDescription = "Search")}
                        1 -> IconButton(onClick = {}){ Icon(painter = painterResource(id = R.drawable.map), contentDescription = "Map")}
                        3 -> IconButton(onClick = {}){ Icon(imageVector = Icons.Default.Share, contentDescription = "Share")}
                        else -> {}
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                DefaultData.navigationItems.forEachIndexed { index, bottomNavigationItem -> 
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                                  selectedItemIndex = index
                            navController.navigateOnce(bottomNavigationItem.title)
                                  },
                        label = {
                                Text(text = bottomNavigationItem.title)
                        },
                        alwaysShowLabel = true,
                        icon = { 
                            BadgedBox(
                                badge = {
                                    if (bottomNavigationItem.badgeCount != null) {
                                        Badge {
                                            Text(text = bottomNavigationItem.badgeCount.toString())
                                        }
                                    } else if (bottomNavigationItem.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) bottomNavigationItem.selectedIcon else bottomNavigationItem.unselectedIcon,
                                    contentDescription = bottomNavigationItem.title
                                )
                            }
                        }
                    )
                }
            }
        }
    ){
        Surface (
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.padding(it)
        ){
            NavHost(navController = navController, startDestination = "Статьи") {
                composable("Статьи"){
                    EducationScreen(educationPageList = DefaultData.educationPageList, onEducationClick = onEducationClick,modifier = Modifier)
                }
                composable("События"){
                    EventScreen(eventList = DefaultData.eventList, navEventController = navEventController, modifier = Modifier)
                }
                composable("Награды"){
                    AchievementScreen(achievementList = DefaultData.achievementList, modifier = Modifier)
                }
                composable("Профиль"){
                    ProfileScreen(user = DefaultData.user, modifier = Modifier)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(){
    TopAppBar(title = { 
        Text(text = "Ecology")
    })
}

private fun NavController.navigateOnce(targetRoute: String) {
    if (this.currentDestination?.route !== targetRoute) {
        this.navigate(targetRoute)
    }
}