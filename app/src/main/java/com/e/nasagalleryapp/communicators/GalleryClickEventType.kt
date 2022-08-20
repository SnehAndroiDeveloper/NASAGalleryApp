package com.e.nasagalleryapp.communicators

import com.e.nasagalleryapp.models.ImageModel

/**
 * Created by Sneha on 17-08-2022.
 */
sealed class GalleryClickEventType {
    object ShowProgress : GalleryClickEventType()
    object HideProgress : GalleryClickEventType()
    object NoInternet : GalleryClickEventType()
    data class ImageDetails(val arrImageList: ArrayList<ImageModel>, val currentPosition: Int) :
        GalleryClickEventType()
}