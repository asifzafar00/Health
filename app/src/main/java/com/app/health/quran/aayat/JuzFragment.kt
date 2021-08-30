package com.app.health.quran.aayat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.health.databinding.AayatViewBinding
import com.app.health.quran.ReadingQuranActvity
import com.app.health.quran.aayat.adapter.QuranAayatAdapter
import com.app.health.quran.aayat.comm.ItemClicks
import com.app.health.util.CommonFunc.CommonFunction
import com.app.health.util.contstant.ContstantsApp

class JuzFragment : Fragment(), ItemClicks {
    private lateinit var viewBinding: AayatViewBinding
    private var name: String? = null
    private lateinit var listener: ItemClicks
    var list: ArrayList<String> = ArrayList()

    companion object {
        fun newInstance(name: String): JuzFragment {
            val args = Bundle()
            args.putSerializable(ContstantsApp.DUAS_ITEMS_NAME, name)
            val fragment = JuzFragment()
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
        viewBinding = AayatViewBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        list = CommonFunction().getListAll();
        val layoutManager = LinearLayoutManager(requireContext())
        viewBinding.mRecyclerView.layoutManager = layoutManager

        viewBinding.mRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        viewBinding.mRecyclerView.adapter = QuranAayatAdapter(requireContext(), list, listener)
    }

    override fun function1(PositionName: String) {
        Log.e("SurahFragment", PositionName)
        val intent = Intent(requireContext(), ReadingQuranActvity::class.java)
        intent.putExtra(ContstantsApp.DUAS_ITEMS_NAME, PositionName)
        startActivity(intent)
    }
}