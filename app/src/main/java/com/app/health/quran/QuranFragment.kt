package com.app.health.quran

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.app.health.R
import com.app.health.databinding.QuranViewBinding
import com.app.health.quran.pageadapter.QuranPagerAdapter
import com.app.health.ui.duas.pageradapter.DemoCollectionPagerAdapter
import com.app.health.util.contstant.ContstantsApp

class QuranFragment : Fragment() {

    private lateinit var viewBinding: QuranViewBinding
    private lateinit var demoCollectionPagerAdapter: QuranPagerAdapter

    companion object {
        fun newInstance(name: String): QuranFragment {
            val args = Bundle()
            args.putSerializable(ContstantsApp.DUAS_ITEMS_NAME, name)
            val fragment = QuranFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = QuranViewBinding.inflate(inflater, container, false)
        return viewBinding.root



    }

    private fun setupViewPager(pager: ViewPager) {
        demoCollectionPagerAdapter = QuranPagerAdapter(childFragmentManager, requireContext())
        viewBinding.pager.adapter = demoCollectionPagerAdapter
        pager.offscreenPageLimit = 0;

        viewBinding.toolBar.title = getString(R.string.quran)
        viewBinding.toolBar.setTitleTextColor(Color.WHITE)

        viewBinding.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.app_bar_search)
        searchItem?.expandActionView()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        setupViewPager(viewBinding.pager);
        viewBinding.tabLayout.setupWithViewPager(viewBinding.pager);
    }

}