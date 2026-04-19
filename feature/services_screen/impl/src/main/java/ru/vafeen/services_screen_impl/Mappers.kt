package ru.vafeen.services_screen_impl

import ru.vafeen.common.ServiceMetadata
import ru.vafeen.services_screen_impl.recycler.Service


internal fun ServiceMetadata.toService(): Service = Service(
    iconRes = iconRes,
    titleRes = titleRes,
    feature = feature,
)
