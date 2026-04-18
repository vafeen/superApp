package ru.vafeen.superapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import jakarta.inject.Inject
import jakarta.inject.Singleton
import ru.vafeen.api.TestProvider
import ru.vafeen.common.navigation.FeatureNavigation
import ru.vafeen.superapp.app.App
import ru.vafeen.superapp.app.AppComponent

@Singleton
internal class MainNavigator @Inject constructor(
    application: Application,
    private val testProvider: TestProvider,
    private val appComponent: AppComponent
) : AndroidViewModel(application), FeatureNavigation {
    override fun openFeature(feature: FeatureNavigation.Feature) {
        when (feature) {
            FeatureNavigation.Feature.Test -> {

//                val testFragment = testProvider.getTestFragment(appComponent)
                Log.e("test", "openFeature$appComponent")
                Log.e("test", "openFeature${getApplication<App>().appComponent}")
            }
        }
    }

}

