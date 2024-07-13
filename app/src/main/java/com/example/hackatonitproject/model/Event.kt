package com.example.hackatonitproject.model

import androidx.annotation.DrawableRes

data class Event(
    val title: String,
    val description: String,
    @DrawableRes
    val image: Int,
    @DrawableRes
    val imageFull: Int,
)
