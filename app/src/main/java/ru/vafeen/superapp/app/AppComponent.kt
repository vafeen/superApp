package ru.vafeen.superapp.app

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import jakarta.inject.Singleton
import ru.vafeen.superapp.MainActivity
import ru.vafeen.test_screen_api.TestDependencies

@Singleton
@Component(modules = [AppModule::class])
internal interface AppComponent : TestDependencies {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}