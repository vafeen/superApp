package ru.vafeen.test_screen_impl

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
import ru.vafeen.test_screen_api.TestProvider

@Module
@InstallIn(SingletonComponent::class)
internal interface TestFeatureModule {
    @Binds
    fun bindsTestProvider(testProviderImpl: TestProviderImpl): TestProvider

    @Binds
    @IntoSet
    fun bindsTestMetadata(testMetadataImpl: TestMetadataImpl): ServiceMetadata

    companion object {
        @Provides
        @IntoMap
        @ClassKey(Feature.Test::class)
        fun bindsTestFragment(): Fragment = TestFragment()
    }
}

