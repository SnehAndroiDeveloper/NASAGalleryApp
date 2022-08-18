package com.e.nasagalleryapp.ui.gallery

import androidx.recyclerview.widget.DiffUtil
import com.e.nasagalleryapp.models.ImageModel

/**
 * Created by Sneha on 18-08-2022.
 */
class GalleryDiffCallback(
    private val oldList: ArrayList<ImageModel>,
    private val newList: ArrayList<ImageModel>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].url == newList[newItemPosition].url
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].toString() == newList[newItemPosition].toString()
    }
}
