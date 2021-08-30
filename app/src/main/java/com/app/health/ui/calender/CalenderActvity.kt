package com.app.health.ui.calender

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.ui.calender.fragment.adapter.Month_calender_adapter
import com.app.health.ui.calender.fragment.comu.ItemClickCalender
import com.app.health.ui.calender.fragment.pojo.MonthBeans
import com.app.health.ui.calender.fragment.pojo.Timings
import com.app.health.ui.calender.pageradapter.MonthPagerAdapter
import com.app.health.util.CommonFunc.CommonFunction
import com.google.gson.Gson
import java.lang.reflect.Field
import java.util.*
import kotlin.collections.ArrayList

class CalenderActvity : AppCompatActivity(), ItemClickCalender, View.OnClickListener {


    private val TAG = "MonthFragment"
    var mList: ArrayList<MonthBeans> = ArrayList()
    var myClic: ItemClickCalender? = null

    var toolBar: Toolbar? = null;
    var progressbar: ProgressBar? = null;
    var mRecyclerView: RecyclerView? = null;
    var geo_date: TextView? = null;

    var previous: TextView? = null
    var next: TextView? = null

    var month: Int? = 0
    var year: Int? = 0
    var namaztime: TextView? = null
    var Fajr: TextView? = null
    var Dhuhr: TextView? = null
    var Asr: TextView? = null
    var Maghrib: TextView? = null
    var Imsak: TextView? = null


    private lateinit var adapter: MonthPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myClic = this

        setContentView(R.layout.calender_view)
        initiazlizationView()
        setUpToolbarView()

    }

    private fun initiazlizationView() {
        toolBar = findViewById(R.id.toolBar)
        progressbar = findViewById(R.id.progressbar)
        mRecyclerView = findViewById(R.id.mRecyclerView)
        geo_date = findViewById(R.id.geo_date)
        previous = findViewById(R.id.previous)
        next = findViewById(R.id.next)



        namaztime = findViewById(R.id.namaztime)
        Fajr = findViewById(R.id.Fajr)
        Dhuhr = findViewById(R.id.Dhuhr)
        Asr = findViewById(R.id.Asr)
        Maghrib = findViewById(R.id.Maghrib)
        Imsak = findViewById(R.id.Imsak)


    }

    private fun setUpToolbarView() {
        toolBar!!.title = getString(R.string.calendar)

        toolBar!!.setTitleTextColor(
            ContextCompat.getColor(
                this,
                R.color.colorWhite
            )
        )

        toolBar!!.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolBar!! as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        next!!.setOnClickListener(this)
        previous!!.setOnClickListener(this)


        setupViewPager();

    }

    private fun setupViewPager() {

        toolBar!!.title = getString(R.string.calendar)
        toolBar!!.setTitleTextColor(Color.WHITE)

        Calendar.getInstance().get(Calendar.MONTH) + 1

        Log.e(TAG, "dadas  " + Calendar.getInstance().get(Calendar.MONTH) + 1)
        month = 4
        year = 2020
        toolBar!!.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        SomeTask("http://api.aladhan.com/v1/calendar?latitude=%2028.7221102&longitude=77.0577056&method=1&month=$month&year=$year").execute()

    }


    inner class SomeTask(var url: String? = null) : AsyncTask<Void, Void, String>() {


        var beans: MonthBeans? = null
        override fun onPreExecute() {
            super.onPreExecute()
            progressbar!!.visibility = View.VISIBLE
            previous!!.visibility = View.GONE
            next!!.visibility = View.GONE
            Log.e("url", "$url")

        }

        override fun doInBackground(vararg params: Void?): String {
            return CommonFunction().postConnectWithOutSll(url)!!
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            Log.e(TAG, result)
            if (result != null) {


                beans = Gson().fromJson(
                    result,
                    MonthBeans::class.java
                )

                progressbar!!.visibility = View.GONE

                mRecyclerView!!.visibility = View.VISIBLE
                previous!!.visibility = View.VISIBLE
                next!!.visibility = View.VISIBLE

                geo_date!!.text =
                    "" + beans!!.getData()!!.get(1)!!.getDate()!!.getGregorian()!!.getMonth()!!
                        .getEn() + "-" +
                            beans!!.getData()!!.get(1)!!.getDate()!!.getGregorian()!!.getYear()
                /*Log.e(
                    TAG,
                    "" + beans!!.getData()!!.get(1)!!.getDate()!!.getGregorian()!!.getMonth()!!
                        .getEn() + "" + beans!!.getData()!!.get(1)!!.getDate()!!.getGregorian()!!
                        .getYear()
                )*/
                val layoutManager = GridLayoutManager(this@CalenderActvity, 5)
                mRecyclerView!!.layoutManager = layoutManager

                mRecyclerView!!.adapter =
                    Month_calender_adapter(this@CalenderActvity, beans, myClic)
                mRecyclerView!!.adapter!!.notifyDataSetChanged()

            }
        }
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

    @SuppressLint("SetTextI18n")
    override fun myItemCLick(timings: Timings?) {

        namaztime!!.visibility = View.VISIBLE
        Fajr!!.visibility = View.VISIBLE
        Dhuhr!!.visibility = View.VISIBLE

        Asr!!.visibility = View.VISIBLE
        Maghrib!!.visibility = View.VISIBLE
        Imsak!!.visibility = View.VISIBLE

        val fields: Array<Field> = Timings::class.java.declaredFields

        println(fields[1].name)
        println(fields[2].name)
        println(fields[3].name)
        println(fields[4].name)
        println(fields[5].name)
        println(fields[6].name)
        println(fields[7].name)
        println(fields[8].name)



        Fajr!!.text = fields[1].name + "-" + timings!!.getFajr()
        Dhuhr!!.text = fields[3].name + "-" + timings.getDhuhr()
        Asr!!.text = fields[4].name + "-" + timings.getAsr()
        Maghrib!!.text = fields[6].name + "-" + timings.getMaghrib()
        Imsak!!.text = fields[7].name + "-" + timings.getIsha()

        Log.e("callls", timings.getAsr().toString())

    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.previous -> {

                month = 3
                year = 2020
                SomeTask("http://api.aladhan.com/v1/calendar?latitude=%2028.7221102&longitude=77.0577056&method=1&month=$month&year=$year").execute()

            }
            R.id.next -> {
                month = 5
                year = 2020
                SomeTask("http://api.aladhan.com/v1/calendar?latitude=%2028.7221102&longitude=77.0577056&method=1&month=$month&year=$year").execute()

            }
        }
    }
}