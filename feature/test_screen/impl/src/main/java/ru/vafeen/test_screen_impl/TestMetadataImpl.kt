package ru.vafeen.test_screen_impl

import jakarta.inject.Inject
import ru.vafeen.common.ServiceMetadata
import ru.vafeen.common.navigation.Feature


internal class TestMetadataImpl @Inject constructor() : ServiceMetadata {
    override val iconRes: Int = R.drawable.test
    override val titleRes: Int = R.string.service_name
    override val feature: Feature = Feature.Test
}