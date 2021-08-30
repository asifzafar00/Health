package com.app.health.ui.cummunity.allprayeradapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import kotlinx.android.synthetic.main.all_prayer_req_row.view.*

class AllPrayerRequestAdapter (val cxt: Context?, private val list: ArrayList<String>?) : RecyclerView.Adapter<AllPrayerRequestAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.all_prayer_req_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bindItems(list!!.get(position))
    }

    override fun getItemCount() = list!!.size

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(mString: String) = with(itemView) {
            itemView.titlecard2.text =mString

            itemView.setOnClickListener(View.OnClickListener {
            })

        }

    }

}

