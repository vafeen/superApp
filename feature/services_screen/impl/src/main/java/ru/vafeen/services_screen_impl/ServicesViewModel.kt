package ru.vafeen.services_screen_impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.flowOf
import ru.vafeen.common.ServiceMetadata

@HiltViewModel
internal class ServicesViewModel @Inject constructor(
    metadata: @JvmSuppressWildcards Set<ServiceMetadata>
) : ViewModel() {
    val metadata = flowOf(metadata.map {
        it.toService()
    })
}