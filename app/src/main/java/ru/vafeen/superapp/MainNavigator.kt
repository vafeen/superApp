package ru.vafeen.superapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import jakarta.inject.Inject
import jakarta.inject.Provider
import jakarta.inject.Singleton
import ru.vafeen.common.navigation.Feature
import ru.vafeen.common.navigation.Navigator

@Singleton
internal class MainNavigator @Inject constructor(
    private val services: @JvmSuppressWildcards Map<Class<*>, Provider<Fragment>>
) :
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
    override fun openFeature(feature: Feature) {
        val fragment = services[feature::class.java]!!
        if (fragmentManager != null) {
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main, fragment.get())
                ?.addToBackStack(null)
                ?.commit()
        } else {
            queue.addLast(fragment.get())
        }
    }

}
