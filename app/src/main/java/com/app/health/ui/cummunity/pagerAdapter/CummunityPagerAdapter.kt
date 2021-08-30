package com.app.health.ui.cummunity.pagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.app.health.ui.cummunity.AllPrayerRequest
import com.app.health.ui.cummunity.MinePrayerRequest

class CummunityPagerAdapter (fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = AllPrayerRequest()
            1 -> fragment = MinePrayerRequest()

        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0)
            return "ALL"
        else if (position == 1)
            return "MINE"
        return ""
    }
}