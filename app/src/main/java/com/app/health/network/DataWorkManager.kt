package com.app.health.network

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.app.health.prayer.AppPrayer
import com.app.health.quran.surah.SurahFragment
import com.app.health.quran.surah.pojo.Datum
import com.app.health.quran.surah.pojo.Surah
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class DataWorkManager(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.e("worker", "working")


        val data = inputData
        val mUrl = data.getString("USER_URL")
        val userName = data.getString("USER_NAME_KEY")

        Log.e("worker", "$mUrl , $userName")

        // val staff =  Gson().fromJson(postConnectWithOutSll(mUrl), Surah::class.java)

//        Log.e("worker", ""+ postConnectWithOutSll(mUrl))

      //  var vf: String? = postConnectWithOutSll(mUrl)
        val outputData = Data.Builder()
            .putBoolean("KEY_MESSAGE", true)
            .build()
      //  SurahFragment().getpojo(postConnectWithOutSll(mUrl))
        return Result.success(outputData)

    }

    fun serializeToJson(myClass: Surah?): String? {
        val gson = Gson()
        return gson.toJson(myClass)
    }

    fun postConnectWithOutSll(url: String?): String? {
        var sb: StringBuilder? = null
        val urlW: URL
        var urlConnection: HttpURLConnection? = null
        var line: String?
        var br: BufferedReader? = null
        try {
            urlW = URL(url)
            urlConnection = urlW.openConnection() as HttpURLConnection
            val responseCode = urlConnection.responseCode

            if (responseCode == HttpURLConnection.HTTP_OK) {

                br = BufferedReader(InputStreamReader(urlConnection.inputStream))
                sb = StringBuilder()

                while (br.readLine().also { line = it } != null) {
                    sb.append(line)
                }
                return sb.toString()
            }
        } catch (e: IOException) {
            return e.message

        } finally {
            br!!.close()
        }
        return sb.toString()
    }


}