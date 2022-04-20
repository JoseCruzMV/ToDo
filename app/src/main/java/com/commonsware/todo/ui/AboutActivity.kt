package com.commonsware.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.commonsware.todo.R
import com.commonsware.todo.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAboutBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.toolbar.title = getString(R.string.app_name)
        binding.about.loadUrl("file:///android_asset/about.html")
    }
}