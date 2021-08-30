package com.app.health.more.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.more.comm.ItemClickCalender
import com.app.health.more.model.MoreMenuModel
import kotlinx.android.synthetic.main.more_menu_row.view.*

class MoreMenuAdapter(
    var ctx: Context? = null,
    var list: ArrayList<MoreMenuModel>? = null,
    var myClic: ItemClickCalender? = null
) : RecyclerView.Adapter<MoreMenuAdapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(
            bean: MoreMenuModel? = null,
            myClic: ItemClickCalender? = null,
            ctx: Context? = null
        ) = with(itemView) {

            itemView.imageView.setImageResource(bean!!.icon)
            itemView.title.text = bean!!.name
            itemView.setOnClickListener(View.OnClickListener {
                bean.name?.let { it1 -> myClic!!.myItemCLick(it1) }
            })

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.more_menu_row,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(list!!.get(position), myClic, ctx)
    }

}