package com.umbrella.newsreader.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.umbrella.newsreader.R

inline fun <reified T : Fragment> newInstanceFragment(bundle: Bundle?): T {
    return T::class.java.newInstance().apply {
        arguments = bundle
    }
}

fun Fragment.getDimen(dimenRes: Int): Float {
    return resources.getDimension(dimenRes)
}

val Fragment.spacePrettySmall
    get() = getDimen(R.dimen.space_pretty_small).toInt()
val Fragment.spaceNormal
    get() = getDimen(R.dimen.space_normal).toInt()
val Fragment.spaceSmall
    get() = getDimen(R.dimen.space_small).toInt()
val Fragment.spaceLarge
    get() = getDimen(R.dimen.space_large).toInt()
val Fragment.spaceTiny
    get() = getDimen(R.dimen.space_tiny).toInt()
val Fragment.spaceAboveNormal
    get() = getDimen(R.dimen.space_above_normal).toInt()