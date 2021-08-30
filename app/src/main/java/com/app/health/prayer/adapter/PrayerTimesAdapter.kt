package com.app.health.prayer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.prayer.model.PrayerModel
import com.app.health.prayer.model.Timings
import kotlinx.android.synthetic.main.today_prayer_row.view.*

class PrayerTimesAdapter(
    val cxt: Context?,
    val beans: PrayerModel
) : RecyclerView.Adapter<PrayerTimesAdapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(timings: Timings? = null) =
            with(itemView) {

//                itemView.title.text = timings!!.getAsr()

                itemView.setOnClickListener(View.OnClickListener {
                })

            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.today_prayer_row,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return 9
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bindItems(beans.getData()!!.getTimings())
    }
}