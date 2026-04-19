package ru.vafeen.services_screen_impl

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.vafeen.common.navigation.Feature
import ru.vafeen.services_screen_api.ServicesProvider

@Module
@InstallIn(SingletonComponent::class)
internal interface ServicesModule {
    @Binds
    fun bindsTestProvider(servicesProviderImpl: ServicesProviderImpl): ServicesProvider


    companion object {
        @Provides
        @IntoMap
        @ClassKey(Feature.Services::class)
        fun bindsServicesFragment(): Fragment = ServicesFragment()
    }

}