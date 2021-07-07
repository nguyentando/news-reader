package com.umbrella.newsreader.view.imageviewer

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ImageViewerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val args = ImageViewerFragmentArgs.fromSavedStateHandle(savedStateHandle).imageViewerModel
    private val _loadImage = MutableStateFlow(args.image)
    val loadImage: StateFlow<String> = _loadImage
}