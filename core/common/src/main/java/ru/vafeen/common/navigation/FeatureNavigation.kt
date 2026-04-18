package ru.vafeen.common.navigation

interface FeatureNavigation {
    fun openFeature(feature: Feature)
    sealed interface Feature {
        data object Test : Feature
    }
}