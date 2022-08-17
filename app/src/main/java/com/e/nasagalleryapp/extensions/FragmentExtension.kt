package com.e.nasagalleryapp.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by Sneha on 17-08-2022.
 */

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this.requireContext(), message, length).show()
