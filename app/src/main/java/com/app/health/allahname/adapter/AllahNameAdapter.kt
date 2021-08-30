package com.app.health.allahname.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.allahname.beans.AllahBeans
import com.app.health.allahname.commm.AllahClickListener
import kotlinx.android.synthetic.main.allha_name_row.view.*

class AllahNameAdapter(
    val cxt: Context,
    var list: ArrayList<AllahBeans> = ArrayList(),
    var listener: AllahClickListener
) : RecyclerView.Adapter<AllahNameAdapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(beans: AllahBeans, listener: AllahClickListener) = with(itemView) {
            itemView.imageView.setImageResource(beans.icon)

            itemView.setOnClickListener(View.OnClickListener {
                Log.e("nammmeme", "" + beans.icon)


                listener.ItemClickLisetner(beans)
                listener.ItemName(beans.meaning)
            })

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.allha_name_row,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.e("pos", "" + position)
        Log.e("list pos", "" + list.get(position).names)

        holder.bindItems(list.get(position), listener)
    }
}