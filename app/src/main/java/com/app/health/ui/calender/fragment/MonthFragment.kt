package com.app.health.ui.calender.fragment


import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.app.health.databinding.MonthCalenderRowBinding
import com.app.health.ui.calender.fragment.adapter.Month_calender_adapter
import com.app.health.ui.calender.fragment.comu.ItemClickCalender
import com.app.health.ui.calender.fragment.pojo.MonthBeans
import com.app.health.util.CommonFunc.CommonFunction
import com.google.gson.Gson


class MonthFragment : Fragment() {

    private val TAG = "MonthFragment"
    private lateinit var viewBinding: MonthCalenderRowBinding
    var mList: ArrayList<MonthBeans> = ArrayList()
    var myClic: ItemClickCalender? = null

    companion object {
        fun newInstance(index: Int): MonthFragment? {
            val newFragment = MonthFragment()
            val args = Bundle()
            args.putInt("index", index)
            newFragment.arguments = args
            return newFragment
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = MonthCalenderRowBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }




}