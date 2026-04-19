package ru.vafeen.superapp

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import ru.vafeen.common.navigation.Navigator

@HiltViewModel
internal class MainActivityViewModel @Inject constructor(
    private val navigator: MainNavigator
) : ViewModel() {
    fun initNavigator(fragmentManager: FragmentManager): Unit =
        navigator.initFragmentManager(fragmentManager)

    fun shutdownNavigator(): Unit = navigator.clearFragmentManager()
    fun openFeature(feature: Navigator.Feature): Unit = navigator.openFeature(feature)
}