package com.app.health.ui.duas

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.app.health.R
import com.app.health.databinding.DuasViewBinding
import com.app.health.ui.duas.pageradapter.DemoCollectionPagerAdapter

class DuasActivity : AppCompatActivity() {

    private lateinit var viewBinding: DuasViewBinding
    private lateinit var demoCollectionPagerAdapter: DemoCollectionPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DuasViewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolBar);
        viewBinding.toolBar.setTitleTextColor(Color.WHITE)

        setupViewPager(viewBinding.pager);
        viewBinding.tabLayout.setupWithViewPager(viewBinding.pager);
    }

    private fun setupViewPager(pager: ViewPager) {
        demoCollectionPagerAdapter = DemoCollectionPagerAdapter(supportFragmentManager)
        viewBinding.pager.adapter = demoCollectionPagerAdapter
        pager.offscreenPageLimit = 0;

        viewBinding.toolBar.title = getString(R.string.duas)

        viewBinding.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(viewBinding.toolBar as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu?.findItem(R.id.app_bar_search)
        searchItem?.expandActionView() // This line will expand the search view.
        return true
    }
}
