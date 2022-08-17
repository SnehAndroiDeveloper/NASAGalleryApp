package com.e.nasagalleryapp.common

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.e.nasagalleryapp.NasaGalleryApp

/**
 * Created by Sneha on 17-08-2022.
 */
abstract class BaseFragment : Fragment(), View.OnClickListener {
    @LayoutRes
    protected abstract fun defineLayoutResource(): Int

    protected abstract fun initializeComponent(view: View) //to initialize the fragment components

    protected abstract fun initToolbar()

    private var lastClickedTime: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(defineLayoutResource(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        initializeComponent(view)
    }

    /**
     * Adds the Fragment into layout container.
     *
     * @param container               Resource id of the layout in which Fragment will be added
     * @param currentFragment         Current loaded Fragment to be hide
     * @param nextFragment            New Fragment to be loaded into container
     * @param commitAllowingStateLoss true if commitAllowingStateLoss is needed
     * @return true if new Fragment added successfully into container, false otherwise
     * @throws ClassCastException    Throws exception if getActivity() is not an instance of BaseActivity
     * @throws IllegalStateException Exception if Fragment transaction is invalid
     */
    protected fun addFragment(
        container: Int,
        currentFragment: Fragment,
        nextFragment: Fragment,
        commitAllowingStateLoss: Boolean
    ) {
        activity?.let {
            if (activity is BaseActivity) {
                (activity as BaseActivity).addFragment(
                    container,
                    currentFragment,
                    nextFragment,
                    commitAllowingStateLoss
                )
            } else {
                throw ClassCastException(BaseActivity::class.java.name + " can not be cast into " + activity!!.javaClass.name)
            }
        }
    }

    /**
     * Replaces the Fragment into layout container.
     *
     * @param container               Resource id of the layout in which Fragment will be added
     * @param nextFragment            New Fragment to be loaded into container
     * @param commitAllowingStateLoss true if commitAllowingStateLoss is needed
     * @return true if new Fragment added successfully into container, false otherwise
     * @throws ClassCastException    Throws exception if getActivity() is not an instance of BaseActivity
     * @throws IllegalStateException Exception if Fragment transaction is invalid
     */
    protected fun replaceFragment(
        container: Int,
        nextFragment: Fragment,
        commitAllowingStateLoss: Boolean
    ) {
        activity?.let {
            if (activity is BaseActivity) {
                (activity as BaseActivity).replaceFragment(
                    container,
                    nextFragment,
                    commitAllowingStateLoss
                )
            } else {
                throw ClassCastException(BaseActivity::class.java.name + " can not be cast into " + activity!!.javaClass.name)
            }
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            initToolbar()
        }
    }

    override fun onClick(view: View) {
        Utils.hideSoftKeyBoard(NasaGalleryApp.instance, view)
        /*
         * Logic to Prevent the Launch of the Fragment Twice if User makes
         * the Tap(Click) very Fast.
         */
        if (SystemClock.elapsedRealtime() - lastClickedTime < Constants.MAX_CLICK_INTERVAL) {
            return
        }
        lastClickedTime = SystemClock.elapsedRealtime()
    }
}