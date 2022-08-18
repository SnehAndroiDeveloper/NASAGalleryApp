package com.e.nasagalleryapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
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

    fun dispatchToAdapter(arrImageList: ArrayList<ImageModel>) {
        val diffCallback = GalleryDiffCallback(this.arrImageList, arrImageList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.arrImageList.clear()
        this.arrImageList.addAll(arrImageList)
        diffResult.dispatchUpdatesTo(this)
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