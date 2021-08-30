package com.app.health.ui.cummunity

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.app.health.R
import com.app.health.databinding.CummunityViewBinding
import com.app.health.databinding.DuasViewBinding
import com.app.health.ui.cummunity.pagerAdapter.CummunityPagerAdapter
import com.app.health.ui.duas.pageradapter.DemoCollectionPagerAdapter

class  CummunityActivity:AppCompatActivity(){

    private lateinit var viewBinding: CummunityViewBinding
    private lateinit var myPagerAdapter: CummunityPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = CummunityViewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setUpToolbarView()

        setupViewPager(viewBinding.pager);
        viewBinding.tabLayout.setupWithViewPager(viewBinding.pager);


    }


    private fun setupViewPager(pager: ViewPager) {
        myPagerAdapter = CummunityPagerAdapter(supportFragmentManager)
        viewBinding.pager.adapter = myPagerAdapter
        pager.offscreenPageLimit = 0;

        viewBinding.toolBar.title = getString(R.string.cummunity)

        viewBinding.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(viewBinding.toolBar as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }
    private fun setUpToolbarView() {
        viewBinding.toolBar.title = getString(R.string.cummunity)

        viewBinding.toolBar.setTitleTextColor(
            ContextCompat.getColor(
                this,
                R.color.colorWhite
            )
        )

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