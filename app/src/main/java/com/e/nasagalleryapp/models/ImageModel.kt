package com.e.nasagalleryapp.models

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Sneha on 17-08-2022.
 */
@Parcelize
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
) : Parcelable {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}
