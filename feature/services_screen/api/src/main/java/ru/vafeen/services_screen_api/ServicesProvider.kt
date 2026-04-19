package ru.vafeen.services_screen_api

import androidx.fragment.app.Fragment

interface ServicesProvider {
    fun getServicesFragment(): Fragment
}