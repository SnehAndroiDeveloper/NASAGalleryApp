package com.e.nasagalleryapp

import android.app.Application

/**
 * Created by Sneha on 17-08-2022.
 */
class NasaGalleryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: NasaGalleryApp
    }

}