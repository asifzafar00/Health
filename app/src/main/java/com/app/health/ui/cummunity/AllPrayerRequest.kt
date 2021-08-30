package com.app.health.ui.cummunity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.health.databinding.FragmentCollectionObjectBinding
import com.app.health.ui.cummunity.allprayeradapter.AllPrayerRequestAdapter
import com.app.health.ui.duas.fragment.duascategories.adapter.CatergoriesDuasAdapter
import com.app.health.ui.fragment.adapter.DuasSubAdapter
import com.app.health.util.CommonFunc.CommonFunction

class AllPrayerRequest : Fragment() {
    private var _binding: FragmentCollectionObjectBinding? = null

    var list: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCollectionObjectBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        list = CommonFunction().getListAll();
        val layoutManager = LinearLayoutManager(requireContext())
        _binding!!.mRecyclerView.layoutManager = layoutManager

        _binding!!.mRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        _binding!!.mRecyclerView.adapter = AllPrayerRequestAdapter(requireContext(),list)
    }
}