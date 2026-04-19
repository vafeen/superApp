package ru.vafeen.superapp.app

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.vafeen.common.ViewModelKey
import ru.vafeen.superapp.MainNavigator
import ru.vafeen.test_screen_impl.TestFeatureModule

@Module(includes = [TestFeatureModule::class])
internal interface AppModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainNavigator::class)
    fun bindsNavigator(mainNavigator: MainNavigator): ViewModel

}