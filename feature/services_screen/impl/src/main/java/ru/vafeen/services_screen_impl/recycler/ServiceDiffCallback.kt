package ru.vafeen.services_screen_impl.recycler

import androidx.recyclerview.widget.DiffUtil

internal class ServiceDiffCallback : DiffUtil.ItemCallback<Service>() {
    override fun areItemsTheSame(oldItem: Service, newItem: Service): Boolean =
        oldItem.iconRes == newItem.iconRes

    override fun areContentsTheSame(oldItem: Service, newItem: Service): Boolean =
        oldItem == newItem
}