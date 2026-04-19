package ru.vafeen.superapp.app

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vafeen.common.navigation.Navigator
import ru.vafeen.superapp.MainNavigator

@Module
@InstallIn(SingletonComponent::class)
internal interface AppModule {
    @Binds
    fun bindsNavigator(mainNavigator: MainNavigator): Navigator

}