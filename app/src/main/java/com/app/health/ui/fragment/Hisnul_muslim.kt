package com.app.health.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.health.R
import com.app.health.databinding.HisnulMuslimViewBinding
import com.app.health.ui.duas.ReadingDuas
import com.app.health.ui.duas.fragment.duascategories.comm.ItemClicks
import com.app.health.ui.fragment.adapter.DuasSubAdapter
import com.app.health.util.CommonFunc.CommonFunction
import com.app.health.util.contstant.ContstantsApp.Companion.DUAS_ITEMS_NAME


class Hisnul_muslim : Fragment(), ItemClicks {

    private var _binding: HisnulMuslimViewBinding? = null
    private val binding get() = _binding!!
    private var name: String? = null
    private lateinit var listener: ItemClicks
    var list: ArrayList<String> = ArrayList()


    companion object {
        fun newInstance(name: String): Hisnul_muslim {
            val args = Bundle()
            args.putSerializable(DUAS_ITEMS_NAME, name)
            val fragment = Hisnul_muslim()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = arguments!!.getString(DUAS_ITEMS_NAME);
        listener = this

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HisnulMuslimViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        _binding!!.toolBar.title = name
        _binding!!.toolBar.setTitleTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorWhite
            )
        )
        _binding!!.toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        list = CommonFunction().getListAll();
        val layoutManager = LinearLayoutManager(requireContext())
        _binding!!.mRecyclerView.layoutManager = layoutManager

        _binding!!.mRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        _binding!!.mRecyclerView.adapter = DuasSubAdapter(requireContext(), list, listener)

    }

    override fun function1(PositionName: String) {
        Log.e("nam", "onCreate: "+PositionName)

        val intent = Intent(requireContext(), ReadingDuas::class.java)
        intent.putExtra(DUAS_ITEMS_NAME, PositionName)
        startActivity(intent)

    }


}