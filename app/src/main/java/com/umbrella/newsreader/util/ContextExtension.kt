package com.umbrella.newsreader.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.TypedValue

fun Context.unWrapContext(): Activity {
    var context: Context? = this
    while (context !is Activity && context is ContextWrapper) {
        context = context.baseContext
    }
    return context as Activity
}

fun Context.getActionBarHeight(): Int? {
    val tv = TypedValue()
    return if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
        TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
    } else {
        null
    }
}