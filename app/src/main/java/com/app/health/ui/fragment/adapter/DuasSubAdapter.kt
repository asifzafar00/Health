package com.app.health.ui.fragment.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.ui.duas.fragment.duascategories.comm.ItemClicks
import kotlinx.android.synthetic.main.duas_catergories_item.view.title
import kotlinx.android.synthetic.main.subduas_catergories_item.view.*

class DuasSubAdapter(
    val cxt: Context?,
    private val list: ArrayList<String>?,
    var listener: ItemClicks
) : RecyclerView.Adapter<DuasSubAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.subduas_catergories_item,
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

        fun bindItems(mString: String, list: ArrayList<String>, listener: ItemClicks) =
            with(itemView) {
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