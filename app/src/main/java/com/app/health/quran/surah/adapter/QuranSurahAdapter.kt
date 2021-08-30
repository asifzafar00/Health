package com.app.health.quran.surah.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.quran.surah.comm.ItemClicks
import com.app.health.quran.surah.model.DuasBeans
import kotlinx.android.synthetic.main.surah_row.view.*

class QuranSurahAdapter(
    val cxt: Context?,
    private val list: ArrayList<DuasBeans>?,
    var listener: ItemClicks
) : RecyclerView.Adapter<QuranSurahAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.surah_row,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(list!!.get(position), list, listener)
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(beans: DuasBeans, list: ArrayList<DuasBeans>, listener: ItemClicks) =
            with(itemView) {
                itemView.title.text = beans.englishName+" - "+beans.name
                itemView.chapter.text = beans.englishNameTranslation+" ("+beans.numberOfAyahs+" )"

                itemView.titleNumber.text = "" + beans.number


                itemView.setOnClickListener(View.OnClickListener {
                    listener.itemClickListener( beans)
                })

            }

    }

}