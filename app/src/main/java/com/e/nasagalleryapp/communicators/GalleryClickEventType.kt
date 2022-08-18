package com.e.nasagalleryapp.communicators

/**
 * Created by Sneha on 17-08-2022.
 */
sealed class GalleryClickEventType {
    object ShowProgress : GalleryClickEventType()
    object HideProgress : GalleryClickEventType()
    object NoInternet : GalleryClickEventType()
    object ImageDetails : GalleryClickEventType()
}