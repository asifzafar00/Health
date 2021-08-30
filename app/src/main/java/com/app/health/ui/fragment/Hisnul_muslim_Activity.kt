package com.app.health.ui.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.health.R
import com.app.health.databinding.ContentFragmentBinding
import com.app.health.util.contstant.ContstantsApp.Companion.DUAS_ITEMS_NAME

class Hisnul_muslim_Activity:AppCompatActivity(){

    private lateinit var binding: ContentFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = getIntent();
        val name = intent.getStringExtra(DUAS_ITEMS_NAME)

        val fragment = Hisnul_muslim.newInstance(name)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.content_fragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }

}