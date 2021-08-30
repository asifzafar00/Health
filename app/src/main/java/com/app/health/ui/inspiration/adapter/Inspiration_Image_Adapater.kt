package com.app.health.ui.inspiration.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.ui.duas.fragment.duascategories.comm.ItemClicks
import com.app.health.ui.duas.fragment.duascategories.model.DuasBeans
import kotlinx.android.synthetic.main.duas_catergories_item.view.*

class Inspiration_Image_Adapater(
    val cxt: Context,
    var list: ArrayList<Int> = ArrayList(),
    var listener: ItemClicks
) : RecyclerView.Adapter<Inspiration_Image_Adapater.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(int: Int, listener: ItemClicks) = with(itemView) {
            itemView.imageView.setImageResource(int)

            itemView.setOnClickListener(View.OnClickListener {
                //listener.function1(beans.title)
            })

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return Inspiration_Image_Adapater.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.inspiration_row,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bindItems(list.get(position), listener)
    }
}