package ru.vafeen.common

import android.content.Context
import android.util.TypedValue

fun Context.toDp(value: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)