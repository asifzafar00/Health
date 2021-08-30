package com.app.health.quran.readingadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.quran.readingbeans.Ayah
import com.app.health.quran.readingbeans.Beans
import com.app.health.quran.surah.comm.SurakLisetner
import kotlinx.android.synthetic.main.reading_surah_row.view.*
import kotlinx.android.synthetic.main.surah_row.view.*

class ReadingAdapter(
    val cxt: Context?,
    val staff: Beans,
    var listener: SurakLisetner
) : RecyclerView.Adapter<ReadingAdapter.MyViewHolder>() {


    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(ayah1: Ayah? = null, ayah2: Ayah? = null, listener: SurakLisetner) =
            with(itemView) {
                itemView.arabi_surah.text = ayah1!!.getText()
                itemView.arabic_english.text = "" + ayah1.getNumber() + ".  " + ayah2!!.getText()
                itemView.english_title.text = "" + ayah1.getNumber() + ".  " + ayah2!!.getText()


                itemView.setOnClickListener(View.OnClickListener {
//                    listener.itemClickListener("beans")
                })


            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return ReadingAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.reading_surah_row,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return staff.getData()?.get(0)!!.getAyahs()!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(
            staff.getData()?.get(0)!!.getAyahs()!!.get(position),
            staff.getData()?.get(1)!!.getAyahs()!!.get(position),
            listener
        )
    }
}