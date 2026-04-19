package ru.vafeen.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface ServiceMetadata {
    @DrawableRes
    fun getIconRes(): Int

    @StringRes
    fun getTitleRes(): Int
}