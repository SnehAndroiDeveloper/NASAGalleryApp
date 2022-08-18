package com.e.nasagalleryapp.results

import com.e.nasagalleryapp.communicators.GalleryDataState
import com.e.nasagalleryapp.models.ImageModel

/**
 * Created by Sneha on 17-08-2022.
 */
data class GalleryResult(
    val result: ArrayList<ImageModel>? = null,
    val state: GalleryDataState = GalleryDataState.Unknown,
    val error: String? = null,
    val errorCode: Int? = null
)
