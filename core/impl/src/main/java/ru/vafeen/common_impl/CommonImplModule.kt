package ru.vafeen.common_impl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vafeen.common.resources.ResourceManager
import ru.vafeen.common_impl.resources.AndroidResourceManager

@Module
@InstallIn(SingletonComponent::class)
internal interface CommonImplModule {
    @Binds
    fun bindsResourceManager(androidResourceManager: AndroidResourceManager): ResourceManager
}