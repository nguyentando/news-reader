package com.umbrella.newsreader.util

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <reified T : Fragment> newInstanceFragment(bundle: Bundle?): T {
    return T::class.java.newInstance().apply {
        arguments = bundle
    }
}