package com.e.nasagalleryapp.ui.imageSlider

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.e.nasagalleryapp.R
import com.e.nasagalleryapp.common.BaseFragment
import com.e.nasagalleryapp.common.Constants
import com.e.nasagalleryapp.communicators.GalleryClickEventType
import com.e.nasagalleryapp.communicators.GalleryDataState
import com.e.nasagalleryapp.communicators.GalleryEvent
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
            imageSliderViewModel.getEvent().collect { galleryResult ->
                when (galleryResult.state) {
                    GalleryDataState.OperationEnd -> {
                        galleryResult.result?.let {
                            imageSliderViewModel.imageSliderAdapter.dispatchToAdapter(it)
                            dataBinding.vpImageSlider.currentItem =
                                imageSliderViewModel.getCurrentPosition()
                        }
                    }

                    is GalleryDataState.PerformOperation -> {
                        when (galleryResult.state.galleryEvent) {
                            is GalleryEvent.ClickEvent -> {
                                when (galleryResult.state.galleryEvent.galleryClickEventType) {
                                    is GalleryClickEventType.PreviousImageDetails -> {
                                        dataBinding.vpImageSlider.currentItem =
                                            galleryResult.state.galleryEvent.galleryClickEventType.position
                                    }

                                    is GalleryClickEventType.NextImageDetails -> {
                                        dataBinding.vpImageSlider.currentItem =
                                            galleryResult.state.galleryEvent.galleryClickEventType.position
                                    }

                                    else -> {}
                                }
                            }

                            else -> {

                            }
                        }
                    }

                    else -> {

                    }
                }
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