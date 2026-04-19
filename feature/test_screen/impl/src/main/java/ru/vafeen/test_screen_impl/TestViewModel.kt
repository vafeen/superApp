package ru.vafeen.test_screen_impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.vafeen.common.navigation.Navigator

@HiltViewModel
internal class TestViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {
    private val _flow = MutableStateFlow(0)
    val flow = _flow.asStateFlow()
    fun openNew() {
        navigator.openFeature(Navigator.Feature.Test)
    }

    fun plus() {
        _flow.update { it + 1 }
    }
}