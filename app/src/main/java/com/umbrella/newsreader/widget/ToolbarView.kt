package com.umbrella.newsreader.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ItemToolbarBinding
import com.umbrella.newsreader.util.*

class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val binding: ItemToolbarBinding
    var title = ""
        set(value) {
            binding.tvTitle.text = value
            field = value
        }
    var iconRes: Int = 0
        set(value) {
            binding.imgvClose.setImageResource(value)
        }
    var showBack: Boolean = false
        set(value) {
            field = value
            binding.imgvClose.apply {
                if (value) {
                    show()
                } else {
                    gone()
                }
            }
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.item_toolbar, this, true)
        binding = ItemToolbarBinding.bind(this)
        context.withStyledAttributes(attrs, R.styleable.ToolbarView, defStyle, 0) {
            getString(R.styleable.ToolbarView_tv_title)?.also {
                title = it
            }
            getBoolean(R.styleable.ToolbarView_show_back, false).also {
                if (it) {
                    binding.imgvClose.show()
                }
            }
            getDrawable(R.styleable.ToolbarView_icon)?.also {
                binding.imgvClose.setImageDrawable(it)
            }
        }
        binding.imgvClose.setOnClickListener {
            context.unWrapContext().onBackPressed()
        }
        context.getActionBarHeight()?.let {
            minimumHeight = it
        }
        setBackgroundColor(getColorAttr(R.attr.colorSurface))
    }

    fun setOnClickCloseBtn(onClickListener: OnClickListener) {
        binding.imgvClose.setOnClickListener(onClickListener)
    }
}