package ru.vafeen.flowers_screen

import jakarta.inject.Inject
import ru.vafeen.common.ServiceMetadata
import ru.vafeen.common.navigation.Feature


internal class FlowersMetadataImpl @Inject constructor() : ServiceMetadata {
    override val iconRes: Int = R.drawable.flower
    override val titleRes: Int = R.string.flowers_service_name
    override val feature: Feature = Feature.Flowers
}