package com.app.health.ui.duas.fragment.duascategories

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.health.R
import com.app.health.databinding.FragmentCollectionObjectBinding
import com.app.health.ui.duas.fragment.duascategories.adapter.CatergoriesDuasAdapter
import com.app.health.ui.duas.fragment.duascategories.comm.ItemClicks
import com.app.health.ui.duas.fragment.duascategories.model.DuasBeans
import com.app.health.ui.fragment.Hisnul_muslim_Activity
import com.app.health.util.CommonFunc.CommonFunction
import com.app.health.util.contstant.ContstantsApp.Companion.DUAS_ITEMS_NAME

class DuasCategoriesFragment : Fragment(), ItemClicks {

    private lateinit var listener: ItemClicks
    private var _binding: FragmentCollectionObjectBinding? = null
    private val binding get() = _binding!!
    var list: ArrayList<DuasBeans> = ArrayList()
    var ctx: Context? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = this
    }

    companion object {
        fun newInstance(foo: String, fooo: String): DuasCategoriesFragment {
            val args = Bundle()
            args.putSerializable("foo", foo)
            val fragment =
                DuasCategoriesFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCollectionObjectBinding.inflate(inflater, container, false)
        ctx = container!!.context;
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        list = CommonFunction().getDatbroadList();

        val layoutManager = GridLayoutManager(ctx, 3)
        _binding!!.mRecyclerView.layoutManager = layoutManager

        _binding!!.mRecyclerView.adapter = CatergoriesDuasAdapter(ctx, list, listener)
    }

    override fun function1(PositionName: String) {
        val intent = Intent(ctx, Hisnul_muslim_Activity::class.java)
        intent.putExtra(DUAS_ITEMS_NAME, PositionName)
        startActivity(intent)

    }

}
