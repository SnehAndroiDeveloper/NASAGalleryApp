package com.e.nasagalleryapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.e.nasagalleryapp.R
import com.e.nasagalleryapp.common.NetworkUtils
import com.e.nasagalleryapp.communicators.GalleryClickEventType
import com.e.nasagalleryapp.communicators.GalleryDataState
import com.e.nasagalleryapp.communicators.GalleryEvent
import com.e.nasagalleryapp.models.ImageModel
import com.e.nasagalleryapp.repositories.GalleryRepository
import com.e.nasagalleryapp.results.GalleryResult
import com.e.nasagalleryapp.ui.imageSlider.ImageSliderAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * Created by Sneha on 22-08-2022.
 */
class ImageSliderViewModel(private val mApplication: Application) : AndroidViewModel(mApplication) {
    private val repository = GalleryRepository(mApplication)

    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val event = MutableSharedFlow<GalleryResult>()

    private var position: Int = -1

    private val imageResultLiveData = MutableLiveData<ArrayList<ImageModel>?>()

    private suspend fun setEvent(galleryResult: GalleryResult) =
        event.emit(galleryResult)

    fun getEvent() = event.asSharedFlow()

    val imageSliderAdapter: ImageSliderAdapter = ImageSliderAdapter(ArrayList(), this)

    fun getImageListLiveData(): LiveData<ArrayList<ImageModel>?> = imageResultLiveData

    fun getCurrentPosition() = position

    fun setCurrentPosition(position: Int) {
        this.position = position
    }

    init {
        defaultScope.launch {
            repository.fetchGalleryImageList().onEach { galleryResult ->
                when (galleryResult.state) {
                    GalleryDataState.OperationEnd -> {
                        galleryResult.result?.let {
                            imageResultLiveData.postValue(it)

                            setEvent(galleryResult)
                        }
                    }

                    else -> {}
                }
            }.launchIn(viewModelScope)
        }
    }

    fun onLeftIconClick(position: Int) {
        defaultScope.launch {
            checkInternetConnection()
            setEvent(
                GalleryResult(
                    state = GalleryDataState.PerformOperation(
                        GalleryEvent.ClickEvent(
                            GalleryClickEventType.PreviousImageDetails(position - 1)
                        )
                    )
                )
            )
        }
    }

    fun onRightIconClick(position: Int) {
        defaultScope.launch {
            checkInternetConnection()
            setEvent(
                GalleryResult(
                    state = GalleryDataState.PerformOperation(
                        GalleryEvent.ClickEvent(
                            GalleryClickEventType.PreviousImageDetails(position + 1)
                        )
                    )
                )
            )
        }
    }

    fun checkInternetConnection() {
        defaultScope.launch {
            if (!NetworkUtils.isInternetAvailable(mApplication)) {
                setEvent(
                    GalleryResult(
                        state = GalleryDataState.PerformOperation(
                            galleryEvent = GalleryEvent.DisplayToast(
                                mApplication.getString(R.string.network_not_available)
                            )
                        )
                    )
                )
            }
        }
    }
}