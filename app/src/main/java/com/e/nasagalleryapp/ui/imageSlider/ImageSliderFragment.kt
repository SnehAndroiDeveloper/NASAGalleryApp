package com.e.nasagalleryapp.ui.imageSlider

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.e.nasagalleryapp.R
import com.e.nasagalleryapp.common.BaseFragment
import com.e.nasagalleryapp.common.Constants
import com.e.nasagalleryapp.databinding.FragmentImageSliderBinding
import com.e.nasagalleryapp.viewmodels.ImageSliderViewModel

/**
 * Created by Sneha on 20-08-2022.
 */
class ImageSliderFragment : BaseFragment<FragmentImageSliderBinding>() {
    private val imageSliderViewModel: ImageSliderViewModel by viewModels()

    init {
        lifecycleScope.launchWhenCreated {
            arguments?.let {
                imageSliderViewModel.setCurrentPosition(it.getInt(Constants.BUNDLE_CURRENT_POSITION))
            }
        }
    }

    override fun defineLayoutResource(): Int {
        return R.layout.fragment_image_slider
    }

    override fun initializeComponent(view: View) {
        dataBinding.position = imageSliderViewModel.getCurrentPosition()
        dataBinding.imageSliderViewModel = imageSliderViewModel
    }

    override fun initToolbar() {
    }
}