package com.e.nasagalleryapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.e.nasagalleryapp.models.ImageModel
import com.e.nasagalleryapp.repositories.GalleryRepository
import com.e.nasagalleryapp.results.GalleryDataResult
import com.e.nasagalleryapp.ui.gallery.ImageAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by Sneha on 17-08-2022.
 */
class GalleryViewModel(private val mApplication: Application) : AndroidViewModel(mApplication) {
    private val repository = GalleryRepository()

    private val defaultScope = CoroutineScope(Dispatchers.Default)

    private val event = MutableSharedFlow<GalleryDataResult>()

    private val imageAdapter: ImageAdapter = ImageAdapter(ArrayList(), this)

    private suspend fun setEvent(galleryDataResult: GalleryDataResult) =
        event.emit(galleryDataResult)

    fun getEvent() = event.asSharedFlow()

    /**
     * To update the image list item
     */
    fun updateItem(imageModel: ImageModel) {
        imageAdapter.updateItem(imageModel)
    }
}