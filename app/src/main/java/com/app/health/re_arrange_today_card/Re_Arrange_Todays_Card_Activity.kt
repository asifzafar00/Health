package com.app.health.re_arrange_today_card

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.health.R
import com.app.health.databinding.ReArrangeTodayCardViewBinding
import com.app.health.re_arrange_today_card.adapter.TodayCardAdapter
import com.app.health.re_arrange_today_card.model.Mybeans
import com.app.health.ui.duas.fragment.duascategories.comm.ItemClicks
import com.app.health.util.CommonFunc.CommonFunction

class Re_Arrange_Todays_Card_Activity : AppCompatActivity(), ItemClicks {


    private var binding: ReArrangeTodayCardViewBinding? = null

    private lateinit var listener: ItemClicks
    var list: ArrayList<Mybeans> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = this
        binding = ReArrangeTodayCardViewBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        list = CommonFunction().getAllTOdayList()
        val layoutManager = LinearLayoutManager(this)
        binding!!.mRecyclerView.layoutManager = layoutManager

        binding!!.mRecyclerView.adapter = TodayCardAdapter(this, list, listener)

        setSupportActionBar(binding!!.toolBar);
        binding!!.toolBar.setTitleTextColor(Color.WHITE);

        binding!!.toolBar.title = getString(R.string.re_arrange)

        binding!!.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(binding!!.toolBar as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    override fun function1(PositionName: String) {
        Log.e("asd", "" + PositionName)
    }
}