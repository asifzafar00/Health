package com.app.health.ui.calender.pageradapter

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.app.health.ui.calender.fragment.MonthFragment

class MonthPagerAdapter(fm: FragmentManager, val ctx: Context) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {

        val fragment: Fragment = MonthFragment.newInstance(1)!!
//        fragment.setInitialSavedState();

        return fragment
    }

    override fun getCount(): Int {
       return 1
    }




    override fun getPageTitle(position: Int): CharSequence? {
        return super.getPageTitle(position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        super.destroyItem(container, position, `object`)
    }
}