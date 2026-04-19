package ru.vafeen.services_screen_impl

import androidx.fragment.app.Fragment
import jakarta.inject.Inject
import ru.vafeen.services_screen_api.ServicesProvider

internal class ServicesProviderImpl @Inject constructor() : ServicesProvider {
    override fun getServicesFragment(): Fragment {
        return ServicesFragment()
    }
}