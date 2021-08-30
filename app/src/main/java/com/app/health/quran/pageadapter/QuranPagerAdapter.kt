package com.app.health.quran.pageadapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.app.health.R
import com.app.health.quran.aayat.JuzFragment
import com.app.health.quran.myquran.MyQuranFragment
import com.app.health.quran.surah.SurahFragment
import com.app.health.util.contstant.ContstantsApp.Companion.QURAN_PAGER_ITEM

class QuranPagerAdapter(fm: FragmentManager, val ctx: Context) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return QURAN_PAGER_ITEM
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return ctx.resources.getString(R.string.surah)
            1 -> return ctx.resources.getString(R.string.juz)
            2 -> return ctx.resources.getString(R.string.my_quran)

        }
        return ""
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = SurahFragment.newInstance("")
            1 -> fragment = JuzFragment.newInstance("")
            2 -> fragment = MyQuranFragment.newInstance("")

        }
        return fragment!!
    }


}


