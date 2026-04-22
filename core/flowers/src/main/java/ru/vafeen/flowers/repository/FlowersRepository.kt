package ru.vafeen.flowers.repository

import kotlinx.coroutines.flow.Flow
import ru.vafeen.flowers.model.Flower

interface FlowersRepository {
    fun getAll(): Flow<List<Flower>>
}