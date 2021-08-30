package com.app.health.ui.inspiration

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.databinding.InspirationViewBinding
import com.app.health.ui.duas.fragment.duascategories.comm.ItemClicks
import com.app.health.ui.inspiration.adapter.Inspiration_Image_Adapater
import com.app.health.util.CommonFunc.CommonFunction

class InspirationActivity : AppCompatActivity(), ItemClicks {

    private lateinit var viewBinding: InspirationViewBinding
    private var list: ArrayList<Int> = ArrayList()
    private lateinit var listener: ItemClicks
    private lateinit var ctx: Context
    private lateinit var layoutManager: RecyclerView.LayoutManager

    var layStatue: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = this
        ctx = this
        viewBinding = InspirationViewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setUpToolbarView()

        list = CommonFunction().getInspirationListImages();

        layoutManager = GridLayoutManager(this, 3)
        viewBinding.mRecyclerView.layoutManager = layoutManager

        viewBinding.mRecyclerView.adapter = Inspiration_Image_Adapater(ctx, list, listener)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_with_button, menu)
        val searchItem = menu?.findItem(R.id.app_bar_search)
        searchItem?.expandActionView()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.app_bar_search -> {
            }
            R.id.changeButton -> changeconf()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun changeconf() {

        if (layStatue){
            Toast.makeText(this, "GridLayoutManager"+layStatue, Toast.LENGTH_LONG).show()

            layoutManager = GridLayoutManager(this, 3)
            viewBinding.mRecyclerView.layoutManager = layoutManager
            viewBinding.mRecyclerView.adapter!!.notifyDataSetChanged()
            layStatue=true
        }else{
            Toast.makeText(this, "LinearLayoutManager"+layStatue, Toast.LENGTH_LONG).show()

            layoutManager = LinearLayoutManager(this)
            viewBinding.mRecyclerView.layoutManager = layoutManager
            viewBinding.mRecyclerView.adapter!!.notifyDataSetChanged()
            layStatue=false
        }


    }

    override fun function1(name: String) {
        Log.e("myclick", name)
    }

}