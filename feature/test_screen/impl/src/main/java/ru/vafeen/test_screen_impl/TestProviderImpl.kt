package ru.vafeen.test_screen_impl

import androidx.fragment.app.Fragment
import jakarta.inject.Inject
import ru.vafeen.test_screen_api.TestDependencies
import ru.vafeen.test_screen_api.TestProvider

internal class TestProviderImpl @Inject constructor() : TestProvider {
    override fun getTestFragment(testDependencies: TestDependencies): Fragment {
        return TestFragment()
    }

    override fun getIconRes(): Int {
        TODO("Not yet implemented")
    }

    override fun getTitleRes(): Int = R.string.service_name
}