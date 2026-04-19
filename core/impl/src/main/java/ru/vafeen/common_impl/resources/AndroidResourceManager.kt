package ru.vafeen.common_impl.resources

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import ru.vafeen.common.resources.ResourceManager

internal class AndroidResourceManager @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourceManager {
    override fun getString(stringRes: Int): String = ContextCompat.getString(context, stringRes)
    override fun getDrawable(iconRes: Int): Drawable = ContextCompat.getDrawable(context, iconRes)
        ?: error("Drawable resource not found: $iconRes")

}