package ru.vafeen.superapp.app

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import jakarta.inject.Singleton
import ru.vafeen.api.TestDependencies
import ru.vafeen.superapp.MainActivity

@Singleton
@Component(modules = [AppModule::class])
internal interface AppComponent : TestDependencies {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}