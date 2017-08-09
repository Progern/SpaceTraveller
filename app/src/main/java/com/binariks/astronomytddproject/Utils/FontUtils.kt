package com.binariks.astronomytddproject.Utils

import android.graphics.Typeface
import android.R.attr.typeface
import android.content.Context
import android.content.res.AssetManager
import android.widget.TextView
import java.util.*


class FontUtils {
    companion object {
        fun setTypeface(context: Context, textView: TextView, fontName: String){
            val assetManager = context.applicationContext.assets
            textView.typeface = Typeface.createFromAsset(assetManager, "fonts/$fontName")

        }
    }
}