package com.android.chiploginapp

import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.TypeSafeMatcher
import org.junit.runner.Description

class ToastMatcher : TypeSafeMatcher<Root?>() {

    override fun describeTo(description: org.hamcrest.Description?) {
        description?.appendText("Login Successful")
    }

    override fun matchesSafely(item: Root?): Boolean {
        val type: Int? = item?.getWindowLayoutParams()?.get()?.type
        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
            val windowToken: IBinder = item.getDecorView().getWindowToken()
            val appToken: IBinder = item.getDecorView().getApplicationWindowToken()
            if (windowToken === appToken) {
                return true
            }
        }
        return false
    }
}