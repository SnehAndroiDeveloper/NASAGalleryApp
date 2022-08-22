package com.e.nasagalleryapp.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.e.nasagalleryapp.R

/**
 * Created by Sneha on 18-08-2022.
 */
@BindingAdapter("galleryImage")
fun setImageViewResource(imageView: ImageView, resource: String?) {
    Glide.with(imageView)
        .load(resource)
        .fallback(R.drawable.ic_no_photo)
        .error(R.drawable.ic_no_photo)
        .into(imageView)
}

@BindingAdapter("totalSize", "currentPosition")
fun itemText(textView: TextView, totalSize: Int, currentPosition: Int) {
    textView.text = "${currentPosition + 1} of $totalSize"
}