package ru.vafeen.superapp.app

import android.app.Application

internal class App : Application() {
    val appComponent: AppComponent = DaggerAppComponent.factory().create(this)
}