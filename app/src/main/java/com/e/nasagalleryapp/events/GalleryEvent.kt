package com.e.nasagalleryapp.events

/**
 * Created by Sneha on 17-08-2022.
 */
sealed class GalleryEvent {

    data class ClickEvent(
        var parcelableData: Any? = null,
        val galleryClickEventType: GalleryClickEventType
    ) : GalleryEvent()

    data class DisplayToast(val message: String) : GalleryEvent()
}