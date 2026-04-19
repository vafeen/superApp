package ru.vafeen.test_screen_impl

import androidx.fragment.app.Fragment
import jakarta.inject.Inject
import ru.vafeen.test_screen_api.TestProvider

internal class TestProviderImpl @Inject constructor() : TestProvider {
    override fun getTestFragment(): Fragment {
        return TestFragment()
    }

}