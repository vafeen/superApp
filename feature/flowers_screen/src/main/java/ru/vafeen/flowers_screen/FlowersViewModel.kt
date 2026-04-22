package ru.vafeen.flowers_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import ru.vafeen.flowers.repository.FlowersRepository

@HiltViewModel
internal class FlowersViewModel @Inject constructor(
    private val flowersRepository: FlowersRepository
) : ViewModel() {
    val flow = flowersRepository.getAll()

}