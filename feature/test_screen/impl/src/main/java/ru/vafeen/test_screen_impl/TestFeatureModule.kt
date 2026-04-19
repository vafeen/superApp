package ru.vafeen.test_screen_impl

import dagger.Binds
import dagger.Module
import ru.vafeen.test_screen_api.TestProvider

@Module
abstract class TestFeatureModule {
    @Binds
    internal abstract fun bindsTestProvider(testProviderImpl: TestProviderImpl): TestProvider
}