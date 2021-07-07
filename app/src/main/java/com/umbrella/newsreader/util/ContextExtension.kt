package com.umbrella.newsreader.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.TypedValue
import com.umbrella.newsreader.R

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

fun Context.screenHeight() = resources.displayMetrics.heightPixels
fun Context.screenWidth() = resources.displayMetrics.widthPixels

fun Context.getDimen(dimenRes: Int): Float {
    return resources.getDimension(dimenRes)
}

val Context.spacePrettySmall
    get() = getDimen(R.dimen.space_pretty_small).toInt()
val Context.spaceNormal
    get() = getDimen(R.dimen.space_normal).toInt()
val Context.spaceSmall
    get() = getDimen(R.dimen.space_small).toInt()
val Context.spaceLarge
    get() = getDimen(R.dimen.space_large).toInt()
val Context.spaceTiny
    get() = getDimen(R.dimen.space_tiny).toInt()
val Context.spaceAboveNormal
    get() = getDimen(R.dimen.space_above_normal).toInt()