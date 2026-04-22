package ru.vafeen.flowers_screen.recycler_list_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jakarta.inject.Inject
import ru.vafeen.flowers.model.Flower
import ru.vafeen.flowers_screen.databinding.FlowerItemBinding

internal class FlowersListAdapter @Inject constructor() :
    ListAdapter<Flower, FlowersListAdapter.FlowersViewHolder>(FlowersDiffCallback()) {
    class FlowersViewHolder(private val binding: FlowerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(flower: Flower) {
            binding.flowerView.setColor(flower.color)
        }
    }

    private class FlowersDiffCallback : DiffUtil.ItemCallback<Flower>() {
        override fun areItemsTheSame(
            oldItem: Flower,
            newItem: Flower
        ): Boolean = oldItem.color == newItem.color

        override fun areContentsTheSame(
            oldItem: Flower,
            newItem: Flower
        ): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlowersViewHolder {
        val binding = FlowerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return FlowersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlowersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}