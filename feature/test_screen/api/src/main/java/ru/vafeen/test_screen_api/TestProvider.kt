package ru.vafeen.test_screen_api

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

interface TestProvider {
    fun getTestFragment(testDependencies: TestDependencies): Fragment

    @DrawableRes
    fun getIconRes(): Int

    @StringRes
    fun getTitleRes(): Int
}
