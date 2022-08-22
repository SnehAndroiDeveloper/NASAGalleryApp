package com.e.nasagalleryapp.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Created by Sneha on 22-08-2022.
 */
object NetworkUtils {
    /**
     * Method to check network connectivity
     */
    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork ?: return false
        val actualNetwork =
            connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            actualNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actualNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actualNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            actualNetwork.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }
}