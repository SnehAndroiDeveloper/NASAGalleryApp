package com.e.nasagalleryapp.repositories

import android.app.Application
import com.e.nasagalleryapp.assetController.AssetController
import com.e.nasagalleryapp.communicators.GalleryDataState
import com.e.nasagalleryapp.results.GalleryResult
import kotlinx.coroutines.flow.flow

/**
 * Created by Sneha on 17-08-2022.
 */
class GalleryRepository(private val mApplication: Application) {
    private val assetController = AssetController(mApplication)

    fun fetchGalleryImageList() = flow {
        emit(GalleryResult(state = GalleryDataState.OperationStart))
        val images = assetController.getImageList()
        emit(
            GalleryResult(
                result = images,
                state = GalleryDataState.OperationEnd
            )
        )
    }

}