package com.e.nasagalleryapp.common

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by Sneha on 17-08-2022.
 */
object Utils {
    fun hideSoftKeyBoard(context: Context, view: View) {
        try {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}