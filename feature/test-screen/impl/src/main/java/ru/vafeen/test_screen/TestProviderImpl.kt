package ru.vafeen.test_screen

import androidx.fragment.app.Fragment
import jakarta.inject.Inject
import ru.vafeen.api.TestDependencies
import ru.vafeen.api.TestProvider

internal class TestProviderImpl @Inject constructor() : TestProvider {
    override fun getTestFragment(testDependencies: TestDependencies): Fragment {
        return TODO()
    }
}