package com.e.nasagalleryapp.ui.activity

import com.e.nasagalleryapp.R
import com.e.nasagalleryapp.common.BaseActivity
import com.e.nasagalleryapp.ui.gallery.GalleryFragment

/**
 * Created by Sneha on 17-08-2022.
 */
class HomeActivity : BaseActivity() {
    override fun defineLayoutResource(): Int {
        return R.layout.activity_home
    }

    override fun initializeComponent() {
        replaceFragment(R.id.clContainer, GalleryFragment(), false)
    }

    override fun initToolbar() {

    }
}