package com.e.nasagalleryapp.ui.gallery

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.e.nasagalleryapp.R
import com.e.nasagalleryapp.common.BaseFragment
import com.e.nasagalleryapp.events.GalleryClickEventType
import com.e.nasagalleryapp.events.GalleryDataState
import com.e.nasagalleryapp.events.GalleryEvent
import com.e.nasagalleryapp.extensions.toast
import com.e.nasagalleryapp.viewmodels.GalleryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Sneha on 17-08-2022.
 */
class GalleryFragment : BaseFragment() {
    private val galleryViewModel: GalleryViewModel by viewModels()

    init {
        lifecycleScope.launchWhenCreated {
            galleryViewModel.getEvent().collect { galleryDataResult ->
                when (galleryDataResult.state) {
                    is GalleryDataState.PerformOperation -> {
                        when (galleryDataResult.state.galleryEvent) {
                            is GalleryEvent.ClickEvent -> {
                                when (galleryDataResult.state.galleryEvent.galleryClickEventType) {
                                    GalleryClickEventType.ImageDetails -> {

                                    }

                                    else -> {}
                                }
                            }

                            is GalleryEvent.DisplayToast -> {
                                withContext(Dispatchers.Main) {
                                    toast(galleryDataResult.state.galleryEvent.message)
                                }
                            }
                        }
                    }

                    else -> {}
                }
            }
        }
    }

    override fun defineLayoutResource(): Int {
        return R.layout.fragment_gallery
    }

    override fun initializeComponent(view: View) {
    }

    override fun initToolbar() {
    }
}