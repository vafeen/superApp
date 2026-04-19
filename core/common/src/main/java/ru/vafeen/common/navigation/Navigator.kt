package ru.vafeen.common.navigation

interface Navigator {
    fun openFeature(feature: Feature)
    sealed interface Feature {
        data object Test : Feature
    }
}