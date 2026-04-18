package ru.vafeen.api

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface TestMetadata {
    @DrawableRes
    fun getIconRes(): Int

    @StringRes
    fun getTitleRes(): Int
}