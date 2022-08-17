package com.e.nasagalleryapp.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Sneha on 17-08-2022.
 */
data class ImageModel(
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("explanation")
    var explanation: String? = null,
    @SerializedName("hdurl")
    var hdurl: String? = null,
    @SerializedName("media_type")
    var mediaType: String? = null,
    @SerializedName("service_version")
    var serviceVersion: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("url")
    var url: String? = null
)
