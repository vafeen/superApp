package ru.vafeen.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.vafeen.common.navigation.Feature

interface ServiceMetadata {
    @get:DrawableRes
    val iconRes: Int

    @get:StringRes
    val titleRes: Int
    val feature: Feature
}