package com.app.health.ui.duas.fragment.MyDuas

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.health.databinding.FragmentCollectionObjectBinding

class MyDuasCatagoriesFragment : Fragment() {

    private var _binding: FragmentCollectionObjectBinding? = null
    private val binding get() = _binding!!
    var ctx: Context? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        _binding = FragmentCollectionObjectBinding.inflate(inflater, container, false)
        ctx = container!!.context;
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}