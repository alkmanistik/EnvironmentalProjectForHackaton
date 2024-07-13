package com.example.hackatonitproject.model

import androidx.annotation.DrawableRes

data class Achievement(
    val title: String,
    val description: String,
    @DrawableRes
    val image: Int,
    val nowProgress: Int,
    val maxProgress: Int = 1,
)
