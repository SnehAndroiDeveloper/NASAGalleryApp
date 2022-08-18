package com.e.nasagalleryapp.assetController

import android.app.Application
import com.e.nasagalleryapp.common.Constants
import com.e.nasagalleryapp.common.Utils
import com.e.nasagalleryapp.models.ImageModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Created by Sneha on 17-08-2022.
 */
class AssetController(private val mApplication: Application) : CoroutineScope {

    suspend fun getImageList(): ArrayList<ImageModel> {
        return withContext(coroutineContext) {
            val jsonFileString = Utils.getJsonDataFromAsset(mApplication, Constants.JSON_FILE_NAME)

            val gson = Gson()
            val imageList = object : TypeToken<List<ImageModel>>() {}.type
            gson.fromJson(jsonFileString, imageList)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}