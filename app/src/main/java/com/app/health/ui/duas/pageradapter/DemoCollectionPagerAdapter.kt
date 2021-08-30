package com.app.health.ui.duas.pageradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.app.health.ui.duas.fragment.duascategories.DuasCategoriesFragment
import com.app.health.ui.duas.fragment.MyDuas.MyDuasCatagoriesFragment

class DemoCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0)
            return "Categories"
        else if (position == 1)
            return "My Daus"
        return ""
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment =DuasCategoriesFragment()
            1 -> fragment = MyDuasCatagoriesFragment()

        }
        return fragment!!
    }


}


