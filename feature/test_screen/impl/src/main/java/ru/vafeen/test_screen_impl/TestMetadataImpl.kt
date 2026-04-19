package ru.vafeen.test_screen_impl

import jakarta.inject.Inject
import ru.vafeen.common.ServiceMetadata


internal class TestMetadataImpl @Inject constructor() : ServiceMetadata {
    override fun getIconRes(): Int = R.drawable.test

    override fun getTitleRes(): Int = R.string.service_name
}