package ru.vafeen.flowers_screen

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import ru.vafeen.common.ServiceMetadata
import ru.vafeen.common.navigation.Feature

@Module
@InstallIn(SingletonComponent::class)
internal interface FlowersModule {
    @Binds
    @IntoSet
    fun bindsFlowersMetadata(flowersMetadataImpl: FlowersMetadataImpl): ServiceMetadata

    companion object {
        @Provides
        @IntoMap
        @ClassKey(Feature.Flowers::class)
        fun bindsServicesFragment(): Fragment = FlowersFragment()
    }
}