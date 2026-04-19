package ru.vafeen.services_screen_impl.recycler

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.vafeen.common.navigation.Feature

internal data class Service(
    @get:DrawableRes
    val iconRes: Int,

    @get:StringRes
    val titleRes: Int,
    val feature: Feature
)
