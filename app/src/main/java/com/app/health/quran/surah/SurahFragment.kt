package com.app.health.quran.surah

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.health.databinding.SurahViewBinding
import com.app.health.quran.ReadingQuranActvity
import com.app.health.quran.surah.adapter.QuranSurahAdapter
import com.app.health.quran.surah.comm.ItemClicks
import com.app.health.quran.surah.model.DuasBeans
import com.app.health.util.CommonFunc.CommonFunction
import com.app.health.util.contstant.ContstantsApp
import org.json.JSONArray
import org.json.JSONObject

class SurahFragment : Fragment(), ItemClicks {
    private lateinit var viewBinding: SurahViewBinding
    private lateinit var listener: ItemClicks
    var list: ArrayList<DuasBeans> = ArrayList()

    companion object {
        fun newInstance(name: String): SurahFragment {
            val args = Bundle()
            args.putSerializable(ContstantsApp.DUAS_ITEMS_NAME, name)
            val fragment = SurahFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = SurahViewBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val task = someTask(viewBinding, listener, list, requireContext()).execute()

    }


    override fun itemClickListener(beans: DuasBeans) {
        val intent = Intent(requireContext(), ReadingQuranActvity::class.java)
        intent.putExtra(ContstantsApp.DUAS_ITEMS_NAME, beans)
        startActivity(intent)
    }


    class someTask(
        var viewBinding: SurahViewBinding,
        var listener: ItemClicks,
        var list: ArrayList<DuasBeans> = ArrayList(),
        var ctx: Context
    ) : AsyncTask<Void, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            viewBinding.progressbar.visibility= View.VISIBLE

        }
        override fun doInBackground(vararg params: Void?): String? {
            return CommonFunction().postConnectWithOutSll("http://api.alquran.cloud/v1/surah")
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObject = JSONObject(result)
                val array: JSONArray = jsonObject.getJSONArray("data")
                for (a in 0 until array.length()) {
                    val subjet = JSONObject(array.getString(a))
                    val beans = DuasBeans(
                        subjet.getInt("number"),
                        subjet.getString("name"),
                        subjet.getString("englishName"),
                        subjet.getString("englishNameTranslation"),
                        subjet.getInt("numberOfAyahs"),
                        subjet.getString("revelationType")
                    )
                    list.add(beans)
                }

            } catch (e: Exception) {}
            viewBinding.progressbar.visibility= View.GONE

            viewBinding.mRecyclerView.visibility = View.VISIBLE
            val layoutManager = LinearLayoutManager(ctx)
            viewBinding.mRecyclerView.layoutManager = layoutManager

            viewBinding.mRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    ctx,
                    DividerItemDecoration.VERTICAL
                )
            )
            viewBinding.mRecyclerView.adapter = QuranSurahAdapter(ctx, list, listener)
        }
    }

}





