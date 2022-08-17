package com.e.nasagalleryapp.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Sneha on 17-08-2022.
 */
open class DataBoundViewHolder<T : ViewDataBinding> internal constructor(val binding: T) :
    RecyclerView.ViewHolder(binding.root)