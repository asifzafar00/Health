package com.app.health.tracker

import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.app.health.R
import com.app.health.databinding.TrackerViewBinding


class TrackerActivity : AppCompatActivity() {
    private lateinit var viewBinding: TrackerViewBinding
    var loc: Location? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = TrackerViewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setUpToolbarView()



    }


    private fun setUpToolbarView() {

        setSupportActionBar(viewBinding.toolBar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        viewBinding.toolBar.title = getString(R.string.inspiration)

        viewBinding.toolBar.setTitleTextColor(
            ContextCompat.getColor(
                this,
                R.color.colorWhite
            )
        )
        viewBinding.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
    }

    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this, "onBackPressed", Toast.LENGTH_LONG).show()
        onBackPressed()
        return true
    }
}