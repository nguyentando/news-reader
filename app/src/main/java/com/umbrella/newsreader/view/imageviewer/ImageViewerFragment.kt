package com.umbrella.newsreader.view.imageviewer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ImageViewerBinding
import com.umbrella.newsreader.util.launchAndCollectIn
import com.umbrella.newsreader.util.loadImage
import com.umbrella.newsreader.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageViewerFragment : Fragment(R.layout.image_viewer) {
    private val vm by viewModels<ImageViewerViewModel>()
    private val binding by viewBinding(ImageViewerBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.loadImage.launchAndCollectIn(viewLifecycleOwner) {
            binding.imgv.loadImage(Glide.with(this@ImageViewerFragment), it)
        }
        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }
}