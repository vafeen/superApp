package ru.vafeen.flowers_impl.repository

import android.graphics.Color
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.vafeen.flowers.model.Flower
import ru.vafeen.flowers.repository.FlowersRepository

@Singleton
internal class RoomFlowersRepository @Inject constructor() : FlowersRepository {
    override fun getAll(): Flow<List<Flower>> = flowOf(
        listOf(
            Flower(Color.MAGENTA),
            Flower(Color.RED),
            Flower(Color.BLUE),
            Flower(Color.CYAN),
        )
    )
}