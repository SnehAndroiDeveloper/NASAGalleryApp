package com.e.nasagalleryapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.e.nasagalleryapp.R
import com.e.nasagalleryapp.common.DataBoundListAdapter
import com.e.nasagalleryapp.databinding.RowImageBinding
import com.e.nasagalleryapp.models.ImageModel
import com.e.nasagalleryapp.viewmodels.GalleryViewModel

/**
 * Created by Sneha on 17-08-2022.
 */
class ImageAdapter(
    private val arrImageList: ArrayList<ImageModel>,
    private val galleryViewModel: GalleryViewModel
) :
    DataBoundListAdapter<ImageModel, RowImageBinding>(arrImageList) {

    override fun createBinding(parent: ViewGroup): RowImageBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_image,
            parent,
            false
        ) as RowImageBinding
    }

    override fun bind(binding: RowImageBinding, position: Int) {
        binding.position = position
        binding.galleryViewModel = galleryViewModel
    }

    fun updateItem(imageModel: ImageModel) {
        arrImageList.forEachIndexed { index, model ->
            if (index >= 0 && index < arrImageList.size) {
                if (model.url == imageModel.url) {
                    notifyItemChanged(index)
                }
            }
        }
    }
}