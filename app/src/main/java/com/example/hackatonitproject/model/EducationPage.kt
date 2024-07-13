package com.example.hackatonitproject.model

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class EducationPage(
    @StringRes
    val title: Int,
    @StringRes
    val description: Int,
    @DrawableRes
    val image: Int,
    val url: String,
)