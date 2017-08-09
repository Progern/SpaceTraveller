package com.binariks.astronomytddproject.Utils

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager


class FullScreenActivityUtils {
    companion object {

        fun hideActionBar(actionBar: android.support.v7.app.ActionBar?) {
            actionBar?.hide()
        }

        fun hideStatusBar(window: Window) {
            if (Build.VERSION.SDK_INT < 16) {
                window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else {
                val decorView = window.decorView
                // Hide the status bar.
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

            }
        }
    }
}
