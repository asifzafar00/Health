package com.app.health.ui.duas.fragment.duascategories.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.ui.duas.fragment.duascategories.comm.ItemClicks
import com.app.health.ui.duas.fragment.duascategories.model.DuasBeans
import kotlinx.android.synthetic.main.duas_catergories_item.view.*

class CatergoriesDuasAdapter(
    val cxt: Context?, private val list: ArrayList<DuasBeans>?,  var listener: ItemClicks
) : RecyclerView.Adapter<CatergoriesDuasAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.duas_catergories_item,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        Log.e("BaseActivityadad", "onCreate: ")
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(list!!.get(position),listener)
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(beans: DuasBeans,listener: ItemClicks) = with(itemView) {
            itemView.title.text = beans.title
            itemView.chapter.text = beans.chapter
            itemView.imageView.setImageResource(beans.imageIcon)

            itemView.setOnClickListener(View.OnClickListener {
                listener.function1(beans.title)
            })

        }

    }

}