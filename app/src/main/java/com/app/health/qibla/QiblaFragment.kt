package com.app.health.qibla

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.health.R
import com.app.health.databinding.QiblaViewBinding
import com.app.health.util.AppPerfrence
import com.app.health.util.contstant.ContstantsApp


class QiblaFragment : Fragment(), SensorEventListener {

    private val TAG = "QiblaFragment"
    var qibleDirection: Float? = null
    private var currentAzimuth = 0f


    private var sensorManager: SensorManager? = null
    private var gsensor: Sensor? = null
    private var msensor: Sensor? = null
    private val mGravity = FloatArray(3)
    private val mGeomagnetic = FloatArray(3)
    private val RI = FloatArray(9)
    private val II = FloatArray(9)

    private var azimuth = 0f
    private val azimuthFix = 0f
    private lateinit var viewBinding: QiblaViewBinding

    companion object {
        fun newInstance(name: String): QiblaFragment {
            val args = Bundle()
            args.putSerializable(ContstantsApp.DUAS_ITEMS_NAME, name)
            val fragment = QiblaFragment()
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
        viewBinding = QiblaViewBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewBinding.toolBar.title = getString(R.string.qibla)
        viewBinding.toolBar.setTitleTextColor(Color.WHITE)
        viewBinding.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)

    }


    fun calculateQibla(latitude: Double, longitude: Double): Float {
        var result: Double? = null

        val longitude2 =
            39.826206 // ka'bah Position https://www.latlong.net/place/kaaba-mecca-saudi-arabia-12639.html

        val longitude1: Double = longitude
        val latitude2 =
            Math.toRadians(21.422487) // ka'bah Position https://www.latlong.net/place/kaaba-mecca-saudi-arabia-12639.html

        val latitude1 = Math.toRadians(latitude)
        val longDiff = Math.toRadians(longitude2 - longitude1)
        val y = Math.sin(longDiff) * Math.cos(latitude2)
        val x =
            Math.cos(latitude1) * Math.sin(latitude2) - Math.sin(
                latitude1
            ) * Math.cos(latitude2) * Math.cos(longDiff)
        result = (Math.toDegrees(Math.atan2(y, x)) + 360) % 360
        val result2 = result.toFloat()
//        SaveFloat("kiblat_derajat", result2)

        viewBinding.teksAtas.setText(
            resources.getString(R.string.qibla_direction)
                    + " " + result2 + " " + resources.getString(
                R.string.degree_from_north
            )
        )
        Toast.makeText(
            requireActivity(), resources.getString(R.string.qibla_direction)
                    + " " + result2 + " " + resources.getString(
                R.string.degree_from_north
            ),
            Toast.LENGTH_LONG
        ).show()
        viewBinding.mainImageQiblat.setVisibility(View.VISIBLE)
        return result2
    }


    fun adjustGambarDial(azimuth: Float) {

//        Log.d(TAG, "will set rotation from " + currentAzimuth + " to " + azimuth);
        val an: Animation = RotateAnimation(
            -currentAzimuth,
            -azimuth,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        currentAzimuth = azimuth
        an.duration = 500
        an.repeatCount = 0
        an.fillAfter = true
        viewBinding.mainImageQiblat!!.startAnimation(an)
    }

    fun adjustArrowQiblat(azimuth: Float) {

        Log.e(TAG, "will set rotation from " + currentAzimuth + " to " + azimuth);

        val kiblat_derajat: Float? = qibleDirection
        val an: Animation = RotateAnimation(
            -currentAzimuth + kiblat_derajat!!,
            -azimuth,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        currentAzimuth = azimuth
        an.duration = 500
        an.repeatCount = 0
        an.fillAfter = true
        viewBinding.mainImageQiblat!!.startAnimation(an)
        if (kiblat_derajat!! > 0) {
            viewBinding.mainImageQiblat.visibility = View.VISIBLE
        } else {
            viewBinding.mainImageQiblat.visibility = View.INVISIBLE
            viewBinding.mainImageQiblat.visibility = View.GONE
        }
    }


    override fun onStart() {
        super.onStart()
        Log.e("TAG", "start compass")
        sensorManager!!.registerListener(this, gsensor, SensorManager.SENSOR_DELAY_GAME)
        sensorManager!!.registerListener(this, msensor, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)

    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume compass")
        sensorManager!!.registerListener(
            this, gsensor,
            SensorManager.SENSOR_DELAY_GAME
        )
        sensorManager!!.registerListener(
            this, msensor,
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    override fun onStop() {
        super.onStop()
        sensorManager!!.unregisterListener(this)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("lat log", "" + AppPerfrence().fetchLastLocation(requireActivity()))


        var lat_log = AppPerfrence().fetchLastLocation(requireActivity())
        var arrString = lat_log!!.split(",")

        qibleDirection = calculateQibla(arrString[0].toDouble(), arrString[1].toDouble())
        viewBinding.teksBawah.text = "" + arrString[0].toDouble() + "," + arrString[1].toDouble()
        viewBinding.teksBawah.visibility = View.VISIBLE

        Log.e("qibdiec", "$qibleDirection")


        //
        sensorManager = requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager

        gsensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        msensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)


    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {

        val alpha = 0.97f

        synchronized(this) {
            if (event!!.sensor.type === Sensor.TYPE_ACCELEROMETER) {
                mGravity[0] = alpha * mGravity[0] + (1 - alpha) * event!!.values[0]
                mGravity[1] = alpha * mGravity[1] + (1 - alpha) * event!!.values[1]
                mGravity[2] = alpha * mGravity[2] + (1 - alpha) * event!!.values[2]

                // mGravity = event.values;

                // Log.e(TAG, Float.toString(mGravity[0]));
            }
            if (event!!.sensor.type === Sensor.TYPE_MAGNETIC_FIELD) {
                // mGeomagnetic = event.values;
                mGeomagnetic[0] = alpha * mGeomagnetic[0] + (1 - alpha) * event!!.values[0]
                mGeomagnetic[1] = alpha * mGeomagnetic[1] + (1 - alpha) * event!!.values[1]
                mGeomagnetic[2] = alpha * mGeomagnetic[2] + (1 - alpha) * event!!.values[2]
                // Log.e(TAG, Float.toString(event.values[0]));
            }
            val success = SensorManager.getRotationMatrix(RI, II, mGravity, mGeomagnetic)
            if (success) {
                val orientation = FloatArray(3)
                SensorManager.getOrientation(RI, orientation)
                 Log.e(TAG, "azimuth (rad): " + azimuth);
                azimuth = Math.toDegrees(orientation[0].toDouble()).toFloat() // orientation
                azimuth = (azimuth + azimuthFix + 360) % 360

                Log.e(TAG, "" + azimuth)


                adjustGambarDial(azimuth);
                adjustArrowQiblat(azimuth);
            }
        }
    }
}