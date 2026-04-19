package ru.vafeen.test_screen_impl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import ru.vafeen.common.ServiceMetadata
import ru.vafeen.test_screen_api.TestProvider

@Module
@InstallIn(SingletonComponent::class)
abstract class TestFeatureModule {
    @Binds
    internal abstract fun bindsTestProvider(testProviderImpl: TestProviderImpl): TestProvider

    @Binds
    @IntoSet
    internal abstract fun bindsTestMetadata(testMetadataImpl: TestMetadataImpl): ServiceMetadata
}