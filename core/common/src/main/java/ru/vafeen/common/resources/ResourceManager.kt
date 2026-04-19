package ru.vafeen.common.resources

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface ResourceManager {
    fun getDrawable(@DrawableRes iconRes: Int): Drawable
    fun getString(@StringRes stringRes: Int): String
}