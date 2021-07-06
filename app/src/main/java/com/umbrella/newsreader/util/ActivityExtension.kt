package com.umbrella.newsreader.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit

fun FragmentActivity.addFragment(
    id: Int,
    fragment: Fragment,
    tag: String? = null,
    isAddBackStack: Boolean = false
) {
    supportFragmentManager.commit(true) {
        add(id, fragment, tag)
        setReorderingAllowed(true)
        if (isAddBackStack) {
            addToBackStack(tag)
        }
    }
}