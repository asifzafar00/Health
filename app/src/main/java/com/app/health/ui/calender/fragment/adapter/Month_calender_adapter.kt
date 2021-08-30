package com.app.health.ui.calender.fragment.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.ui.calender.fragment.comu.ItemClickCalender
import com.app.health.ui.calender.fragment.pojo.*
import kotlinx.android.synthetic.main.day_view_row.view.*

class Month_calender_adapter(
    var ctx: Context? = null,
    var beans: MonthBeans? = null,
    var myClic: ItemClickCalender? = null
) : RecyclerView.Adapter<Month_calender_adapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(
            weekday: Weekday? = null,
            gregorian: Gregorian? = null,
            hijri: Hijri? = null,
            month: Month_? = null,
            year: String? = null,
            timings: Timings? = null,
            myClic: ItemClickCalender? = null,
            ctx: Context? = null
        ) = with(itemView) {

            var gregorianDay: String? = null
            gregorianDay = weekday!!.getEn()
            gregorianDay = gregorianDay!!.substring(0, Math.min(gregorianDay.length, 3));
//            Log.e("name", "$gregorianDay")
            itemView.gregorian_days_name.text = gregorianDay + "-" + gregorian!!.getDay()
//            Log.e("name", "" + gregorianDay + "-" + gregorian!!.getDay())
            itemView.gregorian_days_number.visibility = View.GONE
//            itemView.gregorian_days_number.text = gregorian!!.getDay()

            itemView.hijri_Month_circle.text = hijri!!.getDay()
            itemView.hajri_year_date.text =  year

//            itemView.hijri_Month.text = "" + month!!.getNumber()
            itemView.hijri_month_Name.text = month!!.getEn()

            /* itemView.Fajr.text = "Fajr: " + timings!!.getFajr()
             itemView.Dhuhr.text = "Dhuhr: " + timings!!.getDhuhr()
             itemView.Asr.text = "Asr: " + timings!!.getAsr()
             itemView.Maghrib.text = "Maghrib: " + timings!!.getMaghrib()
             itemView.Imsak.text = "Imsak: " + timings!!.getImsak()*/

            itemView.setOnClickListener(View.OnClickListener {
                myClic!!.myItemCLick(timings)
            })

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.day_view_row,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return beans!!.getData()!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(
            beans!!.getData()!!.get(position)!!.getDate()!!.getGregorian()!!.getWeekday(),
            beans!!.getData()!!.get(position)!!.getDate()!!.getGregorian(),
            beans!!.getData()!!.get(position)!!.getDate()!!.getHijri(),


            beans!!.getData()!!.get(position)!!.getDate()!!.getHijri()!!.getMonth(),
            beans!!.getData()!!.get(position)!!.getDate()!!.getHijri()!!.getYear(),


            beans!!.getData()!!.get(position)!!.getTimings(),
            myClic,
            ctx
        )
    }
}