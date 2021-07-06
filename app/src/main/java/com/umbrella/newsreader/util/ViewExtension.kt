package com.umbrella.newsreader.util

import android.graphics.Color
import android.view.View
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.use

fun View.getColorX(colorId: Int): Int {
    return ContextCompat.getColor(context!!, colorId)
}

fun View.getColorAttr(@AttrRes colorAttr: Int): Int {
    return context.run {
        obtainStyledAttributes(
            intArrayOf(colorAttr)
        ).use {
            it.getColor(0, Color.MAGENTA)
        }
    }
}

fun View.gone() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.fadeIn(duration: Long = 300L) {
    animate().alpha(1f).setDuration(duration).start()
}

fun View.fadeOut() {
    animate().alpha(0f).setDuration(300).start()
}