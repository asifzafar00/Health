package com.app.health.allahname

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.allahname.adapter.AllahNameAdapter
import com.app.health.allahname.beans.AllahBeans
import com.app.health.allahname.commm.AllahClickListener
import com.app.health.databinding.AllahNameViewBinding
import com.app.health.util.CommonFunc.CommonFunction

class AllahNameActivity : AppCompatActivity(), AllahClickListener {
    private lateinit var viewBinding: AllahNameViewBinding
    private var list: ArrayList<AllahBeans> = ArrayList()
    private lateinit var listener: AllahClickListener
    private lateinit var ctx: Context
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listener = this
        ctx = this
        viewBinding = AllahNameViewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setUpToolbarView()

        list = CommonFunction().getListOfAllahName();

        layoutManager = GridLayoutManager(this, 2)
        viewBinding.mRecyclerView.layoutManager = layoutManager
        viewBinding.mRecyclerView.adapter = AllahNameAdapter(ctx, list, listener)

    }

    private fun setUpToolbarView() {

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
    }

    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this, "onBackPressed", Toast.LENGTH_LONG).show()
        onBackPressed()
        return true
    }

    override fun ItemClickLisetner(bean: AllahBeans) {

        var intent = Intent(this@AllahNameActivity, AllahNameDetails::class.java)

        intent.putExtra("beans", bean)
        startActivity(intent)

    }

    override fun ItemName(bean: String?) {
        Log.e("name", "" + bean)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_with_button, menu)
        val searchItem = menu?.findItem(R.id.app_bar_search)
        searchItem?.expandActionView()
        return true
    }
}