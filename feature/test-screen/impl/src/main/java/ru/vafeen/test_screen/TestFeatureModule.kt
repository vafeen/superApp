package ru.vafeen.test_screen

import dagger.Binds
import dagger.Module
import ru.vafeen.api.TestProvider

@Module
abstract class TestFeatureModule {
    @Binds
    internal abstract fun bindsTestProvider(testProviderImpl: TestProviderImpl): TestProvider
}