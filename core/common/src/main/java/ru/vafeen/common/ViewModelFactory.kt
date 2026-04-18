package ru.vafeen.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jakarta.inject.Inject
import jakarta.inject.Singleton
import javax.inject.Provider

@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelProvider = creators[modelClass]
            ?: throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        return viewModelProvider.get() as T
    }
}