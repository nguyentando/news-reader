package com.umbrella.newsreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.umbrella.newsreader.util.addFragment
import com.umbrella.newsreader.util.newInstanceFragment
import com.umbrella.newsreader.view.articlelist.ArticleListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.fragment) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            addFragment(R.id.fragment, newInstanceFragment<ArticleListFragment>(null))
        }
    }
}