package com.e.nasagalleryapp.ui.imageSlider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager.widget.PagerAdapter
import com.e.nasagalleryapp.databinding.RowImageDetailsBinding
import com.e.nasagalleryapp.models.ImageModel
import com.e.nasagalleryapp.viewmodels.ImageSliderViewModel

/**
 * Created by Sneha on 22-08-2022.
 */
class ImageSliderAdapter(
    private val arrImageList: ArrayList<ImageModel>,
    private val viewModel: ImageSliderViewModel
) :
    PagerAdapter() {

    override fun getCount(): Int = arrImageList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding =
            RowImageDetailsBinding.inflate(LayoutInflater.from(container.context), container, false)
        binding.position = position
        binding.imageSliderViewModel = viewModel
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        return container.removeView(`object` as CoordinatorLayout)
    }

    fun dispatchToAdapter(arrImageList: ArrayList<ImageModel>) {
        this.arrImageList.clear()
        this.arrImageList.addAll(arrImageList)
        notifyDataSetChanged()
    }
}