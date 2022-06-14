package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        secFragment(firstfragment())

    }


    private fun secFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentcontainer, fragment)
            .commit()
    }

    override fun dataname(etInput: String) {
        val bundle = Bundle()                   //berisi data yang dibawa dari fragment pengirim
        bundle.putString("name",etInput)

        //data diarahkan ke sec fragment
        val secondFrag = secondfragment()
        secondFrag.arguments = bundle

        this.supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentcontainer, secondFrag).commit()
    }
}