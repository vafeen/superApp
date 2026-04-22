package ru.vafeen.flowers_impl.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vafeen.flowers.repository.FlowersRepository

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    fun bindsFlowersRepository(impl: RoomFlowersRepository): FlowersRepository
}