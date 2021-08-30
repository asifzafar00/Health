package com.app.health.prayer

import android.graphics.Color
import android.location.Location
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.app.health.R
import com.app.health.prayer.model.PrayerModel
import com.app.health.prayer.model.Timings
import com.app.health.util.AppPerfrence
import com.app.health.util.CommonFunc.CommonFunction
import com.app.health.util.contstant.ContstantsApp
import com.google.gson.Gson
import kotlinx.android.synthetic.main.today_prayer_row.*
import java.lang.reflect.Field


class AppPrayer : Fragment() {

    var list: ArrayList<PrayerModel> = ArrayList()

    var toolBar: Toolbar? = null
    var fajr_thumbnail: ImageView? = null
    var fajr_name: TextView? = null
    var fajr_time: TextView? = null

    var sunrise_name: TextView? = null
    var sunrise_timing: TextView? = null


    var Midnight_thumbnail: ImageView? = null
    var Midnight_button: ImageView? = null
    var Midnight_timing: TextView? = null
    var Midnight_name: TextView? = null

    var Imsak_thumbnail: ImageView? = null
    var Imsak_button: ImageView? = null
    var Imsak_timing: TextView? = null
    var Imsak_name: TextView? = null

    var Isha_thumbnail: ImageView? = null
    var Isha_button: ImageView? = null
    var Isha_timing: TextView? = null
    var Isha_name: TextView? = null

    var Maghrib_thumbnail: ImageView? = null
    var Maghrib_button: ImageView? = null
    var Maghrib_timing: TextView? = null
    var Maghrib_name: TextView? = null

    var Sunset_thumbnail: ImageView? = null
    var Sunset_button: ImageView? = null
    var Sunset_timing: TextView? = null
    var Sunset_name: TextView? = null

    var Dhuhr_thumbnail: ImageView? = null
    var Dhuhr_button: ImageView? = null
    var Dhuhr_timing: TextView? = null
    var Dhuhr_name: TextView? = null
    var loc: Location? = null

    var locationName: String? = null

    var viewLinear: LinearLayout? = null

    companion object {

        fun newInstance(name: String): AppPrayer {
            val args = Bundle()
            args.putSerializable(ContstantsApp.DUAS_ITEMS_NAME, name)
            val fragment = AppPrayer()
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

        return inflater.inflate(R.layout.prayer_view, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBar = view.findViewById(R.id.toolBarPrayer)

        fajr_thumbnail = view.findViewById(R.id.fajr_thumbnail)
        fajr_name = view.findViewById(R.id.fajr_name)
        fajr_time = view.findViewById(R.id.fajr_time)


        sunrise_name = view.findViewById(R.id.sunrise_name)
        sunrise_timing = view.findViewById(R.id.sunrise_timing)


        Midnight_thumbnail = view.findViewById(R.id.Midnight_thumbnail)
        Midnight_name = view.findViewById(R.id.Midnight_name)
        Midnight_timing = view.findViewById(R.id.Midnight_timing)
        Midnight_button = view.findViewById(R.id.Midnight_button)

        Imsak_thumbnail = view.findViewById(R.id.Imsak_thumbnail)
        Imsak_name = view.findViewById(R.id.Imsak_name)
        Imsak_timing = view.findViewById(R.id.Imsak_timing)
        Imsak_button = view.findViewById(R.id.Imsak_button)

        Isha_thumbnail = view.findViewById(R.id.Isha_thumbnail)
        Isha_name = view.findViewById(R.id.Isha_name)
        Isha_timing = view.findViewById(R.id.Isha_timing)
        Isha_button = view.findViewById(R.id.Isha_button)

        Maghrib_thumbnail = view.findViewById(R.id.Maghrib_thumbnail)
        Maghrib_name = view.findViewById(R.id.Maghrib_name)
        Maghrib_timing = view.findViewById(R.id.Maghrib_timing)
        Maghrib_button = view.findViewById(R.id.Maghrib_button)

        Sunset_thumbnail = view.findViewById(R.id.Sunset_thumbnail)
        Sunset_name = view.findViewById(R.id.Sunset_name)
        Sunset_timing = view.findViewById(R.id.Sunset_timing)
        Sunset_button = view.findViewById(R.id.Sunset_button)

        Dhuhr_thumbnail = view.findViewById(R.id.Dhuhr_thumbnail)
        Dhuhr_name = view.findViewById(R.id.Dhuhr_name)
        Dhuhr_timing = view.findViewById(R.id.Dhuhr_timing)
        Dhuhr_button = view.findViewById(R.id.Dhuhr_button)

        viewLinear = view.findViewById(R.id.viewLinear)

    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val locNam = AppPerfrence().fetchLastLocAddress(requireContext())


        toolBar!!.title = locNam
        toolBar!!.setTitleTextColor(Color.WHITE)
        toolBar!!.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)


        someTask("http://api.aladhan.com/v1/timingsByAddress?address=$locNam").execute()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    inner class someTask(
        var url: String
    ) : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String? {
            return CommonFunction().postConnectWithOutSll(url)
        }

        override fun onPreExecute() {
            super.onPreExecute()
//            progressbar!!.visibility = View.VISIBLE
            viewLinear!!.visibility = View.VISIBLE

        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            Log.e("res", "" + result)


            if (result != null) {
                Log.e("result", "" + result)

                val beans: PrayerModel =
                    Gson().fromJson(
                        result,
                        PrayerModel::class.java
                    )




                val fields: Array<Field> = Timings::class.java.declaredFields

                for (Field in fields) {
                    println("Name : "+Field.name)
//                    println(fields[1].name)

                }

                viewLinear!!.visibility = View.GONE
                fajr_name!!.text = fields[2].name
                fajr_time!!.text = beans.getData()!!.getTimings()!!.getFajr()
                fajr_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_wb_sunny_black_24dp))
                fajr_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_volume_up_black_24dp))


                sunrise_name!!.text = fields[7].name
                sunrise_timing!!.text = beans.getData()!!.getTimings()!!.getSunrise()
                sunrise_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_brightness_3_black_24dp))
                sunrise_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_volume_off_black_24dp))


                Dhuhr_name!!.text = fields[1].name
                Dhuhr_timing!!.text = beans.getData()!!.getTimings()!!.getDhuhr()
                Dhuhr_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_brightness_3_black_24dp))
                Dhuhr_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_volume_up_black_24dp))

                Maghrib_name!!.text = fields[5].name
                Maghrib_timing!!.text = beans.getData()!!.getTimings()!!.getMaghrib()
                Maghrib_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_wb_sunny_black_24dp))
                Maghrib_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_volume_up_black_24dp))

                Isha_name!!.text = fields[4].name
                Isha_timing!!.text = beans.getData()!!.getTimings()!!.getIsha()
                Isha_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_brightness_3_black_24dp))
                Isha_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_adjust_black_24dp))

                Imsak_name!!.text = fields[3].name
                Imsak_timing!!.text = beans.getData()!!.getTimings()!!.getImsak()
                Imsak_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_brightness_3_black_24dp))
                Imsak_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_volume_off_black_24dp))


                Midnight_name!!.text = fields[6].name
                Midnight_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_brightness_3_black_24dp))
                Midnight_timing!!.text = beans.getData()!!.getTimings()!!.getMidnight()
                Midnight_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_adjust_black_24dp))

                Asr_name!!.text = fields[0].name
                Asr_timing!!.text = beans.getData()!!.getTimings()!!.getAsr()
                Asr_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_brightness_3_black_24dp))
                Asr_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_volume_off_black_24dp))

                Sunset_name!!.text = "Sunset"
                Sunset_timing!!.text = beans.getData()!!.getTimings()!!.getSunset()
                Sunset_thumbnail!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_brightness_3_black_24dp))
                Sunset_button!!.setImageDrawable(requireActivity().getDrawable(R.drawable.ic_volume_up_black_24dp))
            }
        }
    }
}