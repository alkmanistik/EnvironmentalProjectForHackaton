package com.example.hackatonitproject.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.example.hackatonitproject.R
import com.example.hackatonitproject.model.Achievement
import com.example.hackatonitproject.model.BottomNavigationItem
import com.example.hackatonitproject.model.EducationPage
import com.example.hackatonitproject.model.Event
import com.example.hackatonitproject.model.User

class DefaultData(){
    companion object{
        val navigationItems: List<BottomNavigationItem> = listOf(
            BottomNavigationItem(
                title = "Статьи",
                selectedIcon = Icons.Filled.Info,
                unselectedIcon = Icons.Outlined.Info,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = "События",
                selectedIcon = Icons.Filled.DateRange,
                unselectedIcon = Icons.Outlined.DateRange,
                hasNews = false,
                badgeCount = 3,
            ),
            BottomNavigationItem(
                title = "Награды",
                selectedIcon = Icons.Filled.Star,
                unselectedIcon = Icons.Outlined.Star,
                hasNews = true,
            ),
            BottomNavigationItem(
                title = "Профиль",
                selectedIcon = Icons.Filled.AccountCircle,
                unselectedIcon = Icons.Outlined.AccountCircle,
                hasNews = false,
            ),
        )
        val eventList: List<Event> = listOf(
            Event(
                title = "Субботник в парке Якутова",
                description = "Уборка территорий, озеленению и благоустройству общественных мест. Рекомендуем: взять с собой перчатки и прийти в рабочей одежде.\n" +
                        "План мероприятия:\n" +
                        "13:00-13:30 – сбор участников\n" +
                        "13:30-15:00 – уборка территории\n" +
                        "15:00-15:30 – завершение\n" +
                        "Контактный телефон куратора: 79372842942\n",
                image = R.drawable.icon_img_0,
                imageFull = R.drawable.full_img_0,
            ),
            Event(
                title = "Сдача и сбор мусора",
                description = "Организация пунктов приема и сбора мусора",
                image = R.drawable.icon_img_1,
                imageFull = R.drawable.icon_img_1,
            ),
            Event(
                title = "Посадка деревьев",
                description = "Посадка растений в парках, лесах и других подходящих местах",
                image = R.drawable.icon_img_2,
                imageFull = R.drawable.icon_img_2,
            ),
        )

        val achievementList: List<Achievement> = listOf(
            Achievement(
                title = "Участник GreenМир",
                description = "Зарегистрироваться в приложении GreenМир",
                image = R.drawable.a_0,
                nowProgress = 1,
                maxProgress = 1,
            ),
            Achievement(
                title = "Первый вклад в экологию",
                description = "Сходить на первое мероприятие",
                image = R.drawable.a_1,
                nowProgress = 1,
                maxProgress = 1,
            ),
            Achievement(
                title = "Первое знакомство",
                description = "Ознакомиться с статьями о экологии ",
                image = R.drawable.a_2,
                nowProgress = 1,
                maxProgress = 1,
            ),
            Achievement(
                title = "Эко-активист",
                description = "Получить 4 достижения",
                image = R.drawable.a_3,
                nowProgress = 4,
                maxProgress = 4,
            ),
            Achievement(
                title = "Эко-сборщик",
                description = "Сдать первый раз мусор",
                image = R.drawable.a_4,
                nowProgress = 1,
                maxProgress = 1,
            ),
            Achievement(
                title = "Эко-путешественник",
                description = "Воспользоваться картой в приложении",
                image = R.drawable.a_5,
                nowProgress = 1,
                maxProgress = 1,
            ),
            Achievement(
                title = "Эко-друг",
                description = "Пригласить друга в приложение",
                image = R.drawable.a_6,
                nowProgress = 0,
                maxProgress = 1,
            ),
        )
        val user: User = User(
            name = "Эрик",
            nickname = "@alkmanistik",
            email = "erik.fattakhov.04@mail.ru",
            phoneNumber = "89033528719",
        )
        val educationPageList: List<EducationPage> = listOf(
            EducationPage(
                title = R.string.title_0,
                description = R.string.description_0,
                image = R.drawable.img_0,
                url = "https://ecoportal.info/chto-takoe-ekologiya/",
            ),
            EducationPage(
                title = R.string.title_1,
                description = R.string.description_1,
                image = R.drawable.img_1,
                url = "https://trends.rbc.ru/trends/green/5d696a8c9a7947741b7e954d",
            ),
            EducationPage(
                title = R.string.title_2,
                description = R.string.description_2,
                image = R.drawable.img_2,
                url = "https://ecoportal.info/ekologicheskie-problemy-otxodov/",
            ),
            EducationPage(
                title = R.string.title_3,
                description = R.string.description_3,
                image = R.drawable.img_3,
                url = "https://ecoportal.info/nas-i-nashu-planetu-medlenno-ubivaet-plastik/",
            ),
        )
    }
}
