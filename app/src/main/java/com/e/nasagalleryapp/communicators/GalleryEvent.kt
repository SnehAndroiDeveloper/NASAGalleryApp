package com.e.nasagalleryapp.communicators

/**
 * Created by Sneha on 17-08-2022.
 */
sealed class GalleryEvent {

    data class ClickEvent(
        val galleryClickEventType: GalleryClickEventType
    ) : GalleryEvent()

    data class DisplayToast(val message: String) : GalleryEvent()
}