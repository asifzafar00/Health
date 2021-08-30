package com.app.health.mainfirst

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.app.health.R
import com.app.health.re_arrange_today_card.Re_Arrange_Todays_Card_Activity
import com.app.health.ui.calender.CalenderActvity
import com.app.health.ui.cummunity.CummunityActivity
import com.app.health.ui.duas.DuasActivity
import com.app.health.ui.inspiration.InspirationActivity
import com.app.health.util.AppPerfrence
import com.app.health.util.contstant.ContstantsApp


class MainFirstFragment : Fragment(), View.OnClickListener {


    var frame1: FrameLayout? = null
    var frame2: FrameLayout? = null
    var frame3: FrameLayout? = null
    var frame4: FrameLayout? = null
    var today_card_button: TextView? = null
    var toolBar: Toolbar? = null

    companion object {
        fun newInstance(name: String): MainFirstFragment {
            val args = Bundle()
            args.putSerializable(ContstantsApp.DUAS_ITEMS_NAME, name)
            val fragment = MainFirstFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.first_view, container, false);


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame1 = view.findViewById(R.id.frame1)
        frame2 = view.findViewById(R.id.frame2)
        frame3 = view.findViewById(R.id.frame3)
        frame4 = view.findViewById(R.id.frame4)
        today_card_button = view.findViewById(R.id.today_card_button)
        toolBar = view.findViewById(R.id.toolBarfirst)


    }

    var toolbarName: String? = null
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        frame1!!.setOnClickListener(this)
        frame2!!.setOnClickListener(this)
        frame3!!.setOnClickListener(this)
        frame4!!.setOnClickListener(this)
        today_card_button!!.setOnClickListener(this)
        toolbarName = AppPerfrence().fetchLastLocAddress(requireContext())
        Log.e("addressfra", toolbarName)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolBar)
        toolBar!!.setTitleTextColor(Color.WHITE)

//        toolBar!!.title = toolbarName
        activity?.title = toolbarName
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.frame1 -> {
                activity?.startActivity(Intent(activity, DuasActivity::class.java))
            }
            R.id.frame2 -> {
                activity?.startActivity(Intent(activity, InspirationActivity::class.java))
            }
            R.id.frame3 -> {
                activity?.startActivity(Intent(activity, CalenderActvity::class.java))
            }
            R.id.frame4 -> {
                activity?.let {
                    it.startActivity(Intent(it, CummunityActivity::class.java))
                }
            }
            R.id.today_card_button -> {
                activity?.let {
                    it.startActivity(Intent(it, Re_Arrange_Todays_Card_Activity::class.java))
                }
            }
        }
    }


}
