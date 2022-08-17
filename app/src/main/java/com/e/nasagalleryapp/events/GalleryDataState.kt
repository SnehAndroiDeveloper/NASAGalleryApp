package com.e.nasagalleryapp.events

/**
 * Created by Sneha on 17-08-2022.
 */
sealed class GalleryDataState {
    object OperationStart : GalleryDataState()
    object OperationEnd : GalleryDataState()

    data class PerformOperation(val galleryEvent: GalleryEvent) : GalleryDataState()

    object Unknown : GalleryDataState()
}
