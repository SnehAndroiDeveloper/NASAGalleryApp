package com.e.nasagalleryapp.results

import com.e.nasagalleryapp.events.GalleryDataState

/**
 * Created by Sneha on 17-08-2022.
 */
data class GalleryDataResult(
    val result: Any? = null,
    val state: GalleryDataState = GalleryDataState.Unknown,
    val error: String? = null,
    val errorCode: Int? = null
)
