package com.app.health.more

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.app.health.R
import com.app.health.allahname.AllahNameActivity
import com.app.health.allahname.adapter.AllahNameAdapter
import com.app.health.databinding.MoreViewBinding
import com.app.health.more.adapter.MoreMenuAdapter
import com.app.health.more.comm.ItemClickCalender
import com.app.health.more.model.MoreMenuModel
import com.app.health.tracker.TrackerActivity
import com.app.health.ui.calender.CalenderActvity
import com.app.health.ui.cummunity.CummunityActivity
import com.app.health.ui.duas.DuasActivity
import com.app.health.ui.duas.fragment.duascategories.model.DuasBeans
import com.app.health.ui.inspiration.InspirationActivity
import com.app.health.util.CommonFunc.CommonFunction
import com.app.health.util.contstant.ContstantsApp

class MoreFragment : Fragment(), ItemClickCalender {

    private lateinit var viewBinding: MoreViewBinding
    var list: ArrayList<MoreMenuModel> = ArrayList()
    var ctx: Context? = null
    var myClic: ItemClickCalender? = null

    companion object {
        fun newInstance(name: String): MoreFragment {
            val args = Bundle()
            args.putSerializable(ContstantsApp.DUAS_ITEMS_NAME, name)
            val fragment = MoreFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myClic = this

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = MoreViewBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.toolBar.title = "More"
        viewBinding.toolBar.setTitleTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorWhite
            )
        )

        list = CommonFunction().getMoreList();

        val layoutManager = GridLayoutManager(ctx, 3)
        viewBinding.mRecyclerView.layoutManager = layoutManager

        viewBinding.mRecyclerView.adapter = MoreMenuAdapter(ctx, list, myClic)
    }

    override fun myItemCLick(name: String) {
        when (name) {
            "Inspiration" -> {
                activity?.startActivity(Intent(activity, InspirationActivity::class.java))
            }
            "Community" -> {
                activity?.let {
                    it.startActivity(Intent(it, CummunityActivity::class.java))
                }
            }
            "Calendar" -> {
                activity?.let {
                    activity?.startActivity(Intent(activity, CalenderActvity::class.java))
                }
            }
            "Duas" -> {
                activity?.startActivity(Intent(activity, DuasActivity::class.java))
            }
            "Tracker" -> {
                activity?.startActivity(Intent(activity, TrackerActivity::class.java))
            } "Name" -> {
                activity?.startActivity(Intent(activity, AllahNameActivity::class.java))
            }
        }

    }
}