package com.app.health.quran

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.health.R
import com.app.health.databinding.ReadingQuranViewBinding
import com.app.health.quran.readingadapter.ReadingAdapter
import com.app.health.quran.readingbeans.Beans
import com.app.health.quran.readingbeans.ReadingBean
import com.app.health.quran.surah.comm.SurakLisetner
import com.app.health.quran.surah.model.DuasBeans
import com.app.health.util.CommonFunc.CommonFunction
import com.app.health.util.contstant.ContstantsApp
import com.google.gson.Gson


class ReadingQuranActvity : AppCompatActivity(), SurakLisetner {
    private lateinit var listener: SurakLisetner
    private lateinit var binding: ReadingQuranViewBinding
    private var name: String? = null
    var bean: DuasBeans? = null
    var list: ArrayList<ReadingBean> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = this
        binding = ReadingQuranViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
        someTask(
            "http://api.alquran.cloud/v1/surah/${bean!!.number}/editions/quran-uthmani,en.asad,en.pickthall",
            binding, listener, list, this
        ).execute()

    }

    private fun getIntentData() {
        val intent = intent;

        val i = intent
        bean = i.getParcelableExtra<Parcelable>(ContstantsApp.DUAS_ITEMS_NAME) as DuasBeans

        binding.toolBar.title = bean!!.englishName + " " + bean!!.name

        binding.toolBar.setTitleTextColor(
            ContextCompat.getColor(
                this,
                R.color.colorWhite
            )
        )

        binding.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(binding.toolBar as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    class someTask(
        var url: String,
        var viewBinding: ReadingQuranViewBinding,
        var listener: SurakLisetner,
        var list: ArrayList<ReadingBean>? = ArrayList(),
        var ctx: Context
    ) : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void?): String? {

            return CommonFunction().postConnectWithOutSll(url)
        }

        override fun onPreExecute() {
            super.onPreExecute()
            viewBinding.progressbar.visibility= View.VISIBLE

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.e("sdsd", "" + result)
            val staff: Beans =
                Gson().fromJson(
                    result,
                    Beans::class.java
                )

            viewBinding.progressbar.visibility = View.GONE
            viewBinding.mRecyclerView.visibility = View.VISIBLE

            val layoutManager = LinearLayoutManager(ctx)
            viewBinding.mRecyclerView.layoutManager = layoutManager

            viewBinding.mRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    ctx,
                    DividerItemDecoration.VERTICAL
                )
            )
            viewBinding.mRecyclerView.adapter = ReadingAdapter(ctx, staff, listener)
        }

    }

    override fun surahLisetner(mString: String) {

    }
}