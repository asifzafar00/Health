package com.app.health.allahname

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.allahname.beans.AllahBeans
import com.app.health.allahname.commm.AllahClickListener
import com.app.health.databinding.AllhaNameDetailBinding

class AllahNameDetails : AppCompatActivity() {

    private lateinit var viewBinding: AllhaNameDetailBinding
    private var list: ArrayList<AllahBeans> = ArrayList()
    private lateinit var listener: AllahClickListener
    private lateinit var ctx: Context
    private lateinit var layoutManager: RecyclerView.LayoutManager
    var beans: AllahBeans? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ctx = this
        viewBinding = AllhaNameDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setUpToolbarView()

    }

    private fun setUpToolbarView() {

        beans = intent.getSerializableExtra("beans") as? AllahBeans
        Log.e("bne", beans!!.names)
        setSupportActionBar(viewBinding.toolBar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        viewBinding.toolBar.title = getString(R.string.allah_names)
        viewBinding.toolBar.setTitleTextColor(
            ContextCompat.getColor(
                this,
                R.color.colorWhite
            )
        )
        viewBinding.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        viewBinding.title.setText(beans!!.names)
        viewBinding.meanin.setText(beans!!.meaning)
        viewBinding.chapter.setText(beans!!.description)
        viewBinding.frame1.setImageResource(beans!!.icon)

    }

    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this, "onBackPressed", Toast.LENGTH_LONG).show()
        onBackPressed()
        return true
    }

}