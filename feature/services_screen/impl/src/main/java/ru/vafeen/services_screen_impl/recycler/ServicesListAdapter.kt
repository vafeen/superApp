package ru.vafeen.services_screen_impl.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jakarta.inject.Inject
import ru.vafeen.common.navigation.Navigator
import ru.vafeen.common.resources.ResourceManager
import ru.vafeen.services_screen_impl.databinding.ItemServiceBinding

internal class ServicesListAdapter @Inject constructor(
    private val navigator: Navigator,
    private val resourceManager: ResourceManager
) :
    ListAdapter<Service, ServicesListAdapter.ServicesViewHolder>(ServiceDiffCallback()) {

    inner class ServicesViewHolder(private val binding: ItemServiceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(service: Service) {
            binding.serviceName.text = resourceManager.getString(service.titleRes)
            binding.serviceImage.setImageDrawable(resourceManager.getDrawable(service.iconRes))
            binding.root.setOnClickListener {
                navigator.openFeature(service.feature)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val binding = ItemServiceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ServicesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}