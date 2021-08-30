package com.app.health.quran.aayat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.quran.aayat.comm.ItemClicks
import kotlinx.android.synthetic.main.aayat_row.view.*

class QuranAayatAdapter (
    val cxt: Context?,
    private val list: ArrayList<String>?,
    var listener: ItemClicks
) : RecyclerView.Adapter<QuranAayatAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.aayat_row,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(list!![position], list, listener)
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(mString: String, list: ArrayList<String>, listener: ItemClicks) =      with(itemView) {
                itemView.title.text = mString
                var cc: Int
                cc = 1 + list.indexOf(mString)
                itemView.titleNumber.text = "" + cc+" ."

                itemView.setOnClickListener(View.OnClickListener {
                    listener.function1(mString)
                })

            }

    }

}