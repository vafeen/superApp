package ru.vafeen.superapp

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import jakarta.inject.Inject
import jakarta.inject.Singleton
import ru.vafeen.common.navigation.FeatureNavigation
import ru.vafeen.superapp.app.AppComponent
import ru.vafeen.test_screen_api.TestProvider

@Singleton
internal class MainNavigator @Inject constructor(
    application: Application,
    private val testProvider: TestProvider,
    private val appComponent: AppComponent
) : AndroidViewModel(application), FeatureNavigation {
    private val queue = ArrayDeque<Fragment>()
    private var fragmentManager: FragmentManager? = null

    @Synchronized
    fun init(fragmentManager: FragmentManager) {
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


    fun shutdown() {
        fragmentManager = null
    }

    @Synchronized
    override fun openFeature(feature: FeatureNavigation.Feature) {
        val fragment = when (feature) {
            FeatureNavigation.Feature.Test ->
                testProvider.getTestFragment(appComponent)
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

