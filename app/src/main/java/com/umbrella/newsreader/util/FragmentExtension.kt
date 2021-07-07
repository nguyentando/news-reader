package com.umbrella.newsreader.util

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <reified T : Fragment> newInstanceFragment(bundle: Bundle?): T {
    return T::class.java.newInstance().apply {
        arguments = bundle
    }
}

fun Fragment.getDimen(dimenRes: Int): Float {
    return requireContext().getDimen(dimenRes)
}

val Fragment.spacePrettySmall
    get() = requireContext().spacePrettySmall
val Fragment.spaceNormal
    get() = requireContext().spaceNormal
val Fragment.spaceSmall
    get() = requireContext().spaceSmall
val Fragment.spaceLarge
    get() = requireContext().spaceLarge
val Fragment.spaceTiny
    get() = requireContext().spaceTiny
val Fragment.spaceAboveNormal
    get() = requireContext().spaceAboveNormal