package com.e.nasagalleryapp.ui.gallery

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.e.nasagalleryapp.R
import com.e.nasagalleryapp.common.BaseFragment
import com.e.nasagalleryapp.communicators.GalleryClickEventType
import com.e.nasagalleryapp.communicators.GalleryDataState
import com.e.nasagalleryapp.communicators.GalleryEvent
import com.e.nasagalleryapp.databinding.FragmentGalleryBinding
import com.e.nasagalleryapp.extensions.toast
import com.e.nasagalleryapp.viewmodels.GalleryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Sneha on 17-08-2022.
 */
class GalleryFragment : BaseFragment<FragmentGalleryBinding>() {
    private val galleryViewModel: GalleryViewModel by viewModels()

    init {
        lifecycleScope.launchWhenCreated {
            galleryViewModel.getEvent().collect { galleryResult ->
                when (galleryResult.state) {
                    is GalleryDataState.PerformOperation -> {
                        when (galleryResult.state.galleryEvent) {
                            is GalleryEvent.ClickEvent -> {
                                when (galleryResult.state.galleryEvent.galleryClickEventType) {
                                    GalleryClickEventType.ImageDetails -> {

                                    }

                                    else -> {}
                                }
                            }

                            is GalleryEvent.DisplayToast -> {
                                withContext(Dispatchers.Main) {
                                    toast(galleryResult.state.galleryEvent.message)
                                }
                            }
                        }
                    }

                    is GalleryDataState.OperationEnd -> {
                        galleryResult.result?.let {
                            galleryViewModel.imageAdapter.dispatchToAdapter(it)
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
        dataBinding.galleryViewModel = galleryViewModel

        galleryViewModel.fetchGalleryData()
    }

    override fun initToolbar() {
    }
}