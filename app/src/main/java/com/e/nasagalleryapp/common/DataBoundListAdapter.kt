package com.e.nasagalleryapp.common

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Sneha on 17-08-2022.
 */
abstract class DataBoundListAdapter<T, V : ViewDataBinding>(private val items: MutableList<T>) :
    RecyclerView.Adapter<DataBoundViewHolder<V>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<V> {
        val binding = createBinding(parent)
        return DataBoundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<V>, position: Int) {
        bind(holder.binding, position)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    abstract fun createBinding(parent: ViewGroup): V
    abstract fun bind(binding: V, position: Int)
}