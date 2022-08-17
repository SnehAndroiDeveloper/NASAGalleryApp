package com.e.nasagalleryapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.e.nasagalleryapp.repositories.GalleryRepository
import com.e.nasagalleryapp.results.GalleryDataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by Sneha on 17-08-2022.
 */
class GalleryViewModel(val mApplication: Application) : AndroidViewModel(mApplication) {
    private val repository = GalleryRepository()

    private val defaultScope = CoroutineScope(Dispatchers.Default)

    private val event = MutableSharedFlow<GalleryDataResult>()

    private suspend fun setEvent(campusSettingsResult: GalleryDataResult) =
        event.emit(campusSettingsResult)

    fun getEvent() = event.asSharedFlow()
}