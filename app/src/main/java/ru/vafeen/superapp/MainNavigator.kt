package ru.vafeen.superapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import jakarta.inject.Inject
import jakarta.inject.Singleton
import ru.vafeen.common.navigation.Navigator
import ru.vafeen.test_screen_api.TestProvider


@Singleton
internal class MainNavigator @Inject constructor(private val testProvider: TestProvider) :
    Navigator {
    private val queue = ArrayDeque<Fragment>()
    private var fragmentManager: FragmentManager? = null

    @Synchronized
    fun initFragmentManager(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
        while (queue.isNotEmpty()) {
            queue.removeFirstOrNull()?.let { fragment ->
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.main, fragment)
                    .addToBackStack(null)
                    .commit()

            }
        }
    }


    fun clearFragmentManager() {
        fragmentManager = null
    }

    @Synchronized
    override fun openFeature(feature: Navigator.Feature) {
        val fragment: Fragment = when (feature) {
            Navigator.Feature.Test -> testProvider.getTestFragment()
        }
        if (fragmentManager != null) {
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main, fragment)
                ?.addToBackStack(null)
                ?.commit()
        } else {
            queue.addLast(fragment)
        }
    }

}

