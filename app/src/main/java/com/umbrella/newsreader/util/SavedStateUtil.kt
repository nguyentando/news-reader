package com.umbrella.newsreader.util

import android.os.Bundle
import android.os.Parcelable
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle

interface SavedStateHandleManager {
    fun <T : Parcelable> getNavArgs(savedStateHandle: SavedStateHandle): T
}

private const val EXTRA_BUNDLE = "xBundle"

internal class SavedStateHandleManagerImpl : SavedStateHandleManager {
    // used in view model of fragment
    override fun <T : Parcelable> getNavArgs(savedStateHandle: SavedStateHandle): T {
        return savedStateHandle.get<T>(EXTRA_BUNDLE)!!
    }
}

fun getBundle(parcelable: Parcelable): Bundle {
    return bundleOf(EXTRA_BUNDLE to parcelable)
}