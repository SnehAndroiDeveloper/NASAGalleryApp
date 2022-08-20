package com.e.nasagalleryapp.ui.imageSlider

import android.view.View
import com.e.nasagalleryapp.R
import com.e.nasagalleryapp.common.BaseFragment
import com.e.nasagalleryapp.databinding.FragmentImageSliderBinding

/**
 * Created by Sneha on 20-08-2022.
 */
class ImageSliderFragment : BaseFragment<FragmentImageSliderBinding>() {

    override fun defineLayoutResource(): Int {
        return R.layout.fragment_image_slider
    }

    override fun initializeComponent(view: View) {
    }

    override fun initToolbar() {
    }
}