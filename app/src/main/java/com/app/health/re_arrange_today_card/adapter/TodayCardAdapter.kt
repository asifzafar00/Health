package com.app.health.re_arrange_today_card.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.re_arrange_today_card.model.Mybeans
import com.app.health.ui.duas.fragment.duascategories.comm.ItemClicks
import kotlinx.android.synthetic.main.todays_card_items.view.*

class TodayCardAdapter(
    val cxt: Context?, private val list: ArrayList<Mybeans>?, var listener: ItemClicks
) : RecyclerView.Adapter<TodayCardAdapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(beans: Mybeans, listener: ItemClicks) = with(itemView) {
            itemView.titlet.text = beans.title
            itemView.subTitlet.text = beans.subTitle

            itemView.setOnClickListener(View.OnClickListener {
                listener.function1(beans.title)
            })

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return TodayCardAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todays_card_items,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(list!!.get(position), listener)

    }

}