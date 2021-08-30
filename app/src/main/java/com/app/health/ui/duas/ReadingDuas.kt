package com.app.health.ui.duas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.app.health.R
import com.app.health.databinding.ContentFragmentBinding
import com.app.health.databinding.ReadingDausViewBinding
import com.app.health.util.contstant.ContstantsApp

class ReadingDuas : AppCompatActivity() {

    private lateinit var binding: ReadingDausViewBinding

    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ReadingDausViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentData()


    }

    private fun getIntentData() {
        val intent = intent;
        name = intent.getStringExtra(ContstantsApp.DUAS_ITEMS_NAME)

        binding.toolBar.title = name

        binding.toolBar.setTitleTextColor(
            ContextCompat.getColor(
                this,
                R.color.colorWhite
            )
        )

        binding.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(binding.toolBar as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}